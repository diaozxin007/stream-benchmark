package com.xilidou;


import org.openjdk.jmh.annotations.*;
import org.openjdk.jmh.runner.Runner;
import org.openjdk.jmh.runner.RunnerException;
import org.openjdk.jmh.runner.options.Options;
import org.openjdk.jmh.runner.options.OptionsBuilder;

import java.util.*;
import java.util.concurrent.TimeUnit;

@BenchmarkMode(Mode.AverageTime)
@OutputTimeUnit(TimeUnit.MILLISECONDS)
@State(Scope.Benchmark)
@Fork(value = 2, jvmArgs = {"-Xms2G", "-Xmx2G"})
public class IntTest {

    @Param({"10000", "100000", "1000000"})
    private int length;

    private List<Integer> integers;

    public static void main(String[] args) throws RunnerException {

        Options opt = new OptionsBuilder()
                .include(IntTest.class.getSimpleName())
                .forks(1)
                .warmupIterations(1)
                .measurementIterations(2)
                .build();

        new Runner(opt).run();

    }

    @Setup
    public void warmUp(){
        integers = createData();
        int i = minIntFor();
        int i1 = minIntStream();
        int i2 = minIntParallelStream();

    }

    @Benchmark
    public int minIntFor(){
        int min = Integer.MAX_VALUE;
        for (Integer integer : integers) {
            if (integer < min){
                min = integer;
            }
        }
        return min;
    }

    @Benchmark
    public int minIntStream(){
        return integers.stream().min(Comparator.comparing(Integer::valueOf)).get();
    }

    @Benchmark
    public int minIntParallelStream(){
        return integers.parallelStream().min(Comparator.comparing(Integer::valueOf)).get();
    }

    private List<Integer> createData(){

        List<Integer> integers = new ArrayList<>();

        Random r = new Random();
        for(int i=0; i<length; i++){
            integers.add(r.nextInt());
        }
        return integers;
    }
}