package com.xilidou;

import org.openjdk.jmh.annotations.*;
import org.openjdk.jmh.runner.Runner;
import org.openjdk.jmh.runner.RunnerException;
import org.openjdk.jmh.runner.options.Options;
import org.openjdk.jmh.runner.options.OptionsBuilder;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;

@BenchmarkMode(Mode.AverageTime)
@OutputTimeUnit(TimeUnit.MILLISECONDS)
@State(Scope.Benchmark)
@Fork(value = 2, jvmArgs = {"-Xms2G", "-Xmx2G"})
public class BigObjectTest {

    @Param({"10000", "100000", "1000000"})
    private int length;

    private List<BigObject> objects;

    public static void main(String[] args) throws RunnerException {

        Options opt = new OptionsBuilder()
                .include(BigObjectTest.class.getSimpleName())
                .forks(1)
                .warmupIterations(1)
                .measurementIterations(2)
                .build();

        new Runner(opt).run();

    }

    @Setup
    public void warmUp(){
        objects = createData();
        BigObject bigObject = minFor();
        BigObject bigObject1 = minStream();
        BigObject bigObject2 = minParallelStream();


    }

    @Benchmark
    public BigObject minFor(){
        int min = Integer.MAX_VALUE;
        BigObject result = null;

        for (BigObject object : objects) {

            com.xilidou.BigObject.Address address = object.getAddress();
            if(address.getNumber() < min){
                min = address.getNumber();
                result= object;
            }

        }

        return result;
    }

    @Benchmark
    public BigObject minStream(){

        return objects.stream().min(Comparator.comparing(
                t -> t.getAddress().getNumber()
        )).get();

    }

    @Benchmark
    public BigObject minParallelStream(){
        return objects.parallelStream().min(Comparator.comparing(
                t -> t.getAddress().getNumber()
        )).get();


    }

    private List<BigObject> createData(){

        List<BigObject> list = new ArrayList<>();

        Random r = new Random();
        for(int i=0; i<length; i++){

            BigObject bigObject = new BigObject();

            BigObject.Address address = new BigObject.Address();

            bigObject.setId(r.nextLong());
            bigObject.setAge(r.nextInt());

            bigObject.setEmail(Utils.getAlphaNumericString(10));
            bigObject.setName(Utils.getAlphaNumericString(5));
            address.setCity(Utils.getAlphaNumericString(5));
            address.setCountry(Utils.getAlphaNumericString(4));
            address.setStreat(Utils.getAlphaNumericString(15));
            address.setNumber(r.nextInt(5));

            bigObject.setAddress(address);

            list.add(bigObject);
        }

        return list;
    }

}
