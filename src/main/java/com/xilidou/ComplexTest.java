package com.xilidou;

import org.apache.commons.lang3.StringUtils;
import org.openjdk.jmh.annotations.*;
import org.openjdk.jmh.runner.Runner;
import org.openjdk.jmh.runner.RunnerException;
import org.openjdk.jmh.runner.options.Options;
import org.openjdk.jmh.runner.options.OptionsBuilder;

import java.util.*;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

@BenchmarkMode(Mode.AverageTime)
@OutputTimeUnit(TimeUnit.MILLISECONDS)
@State(Scope.Benchmark)
@Fork(value = 2, jvmArgs = {"-Xms2G", "-Xmx2G"})
public class ComplexTest {


    @Param({"10000", "100000", "1000000"})
    private int length;


    private List<BigObject> objects;

    private String citys = "河北省、山西省、辽宁省、吉林省、黑龙江省、江苏省、浙江省、安徽省、福建省、江西省、山东省、河南省、湖北省、湖南省、广东省、广西省、海南省、四川省、贵州省、云南省、陕西省、甘肃省、青海省、台湾省";

    private List<String> cityList = Arrays.asList(StringUtils.split(citys, "、"));


    public static void main(String[] args) throws RunnerException {

        Options opt = new OptionsBuilder()
                .include(ComplexTest.class.getSimpleName())
                .forks(1)
                .warmupIterations(1)
                .measurementIterations(2)
                .build();

        new Runner(opt).run();

    }

    @Setup
    public void warmUp(){
        objects = createData();
        Map<String, Double> bigObject = minFor();
        Map<String, Double> stringDoubleMap1 = minStream();
        Map<String, Double> stringDoubleMap = minParallelStream();


    }

    @Benchmark
    public Map<String,Double> minFor(){
        Map<String, Double> map = new HashMap<>();
        Map<String,Integer> countMap = new HashMap<>();
        Map<String,Integer> sumMap = new HashMap<>();

        for (BigObject object : objects) {

            String key = object.getAddress().getCity();

            Integer count = countMap.getOrDefault(key, 0);
            count = count + 1;
            countMap.put(key,count);

            Integer sum = sumMap.getOrDefault(key, 0);
            sum = sum + object.getAge();
            sumMap.put(key, sum);

        }

        for (Map.Entry<String, Integer> stringIntegerEntry : countMap.entrySet()) {

            String key = stringIntegerEntry.getKey();

            Double avg = Double.valueOf( sumMap.get(key))/ countMap.get(key);

            map.put(key, avg);

        }

        return map;
    }

    @Benchmark
    public Map<String, Double> minStream(){

        return objects.stream().collect(
                Collectors.groupingBy(t-> t.getAddress().getCity(),
                        Collectors.averagingInt(BigObject::getAge)));

    }

    @Benchmark
    public Map<String, Double> minParallelStream(){
        return objects.parallelStream().collect(
                Collectors.groupingBy(t-> t.getAddress().getCity(),
                        Collectors.averagingInt(BigObject::getAge)));


    }

    private List<BigObject> createData(){

        List<BigObject> list = new ArrayList<>();

        Random r = new Random();
        for(int i=0; i<length; i++){

            BigObject bigObject = new BigObject();

            BigObject.Address address = new BigObject.Address();

            bigObject.setId(r.nextLong());
            bigObject.setAge(Math.abs(r.nextInt() % 100));

            bigObject.setEmail(Utils.getAlphaNumericString(10));
            bigObject.setName(Utils.getAlphaNumericString(5));

            int index =  Math.abs(r.nextInt()) % cityList.size();

            address.setCity(cityList.get(index));
            address.setCountry(Utils.getAlphaNumericString(4));
            address.setStreat(Utils.getAlphaNumericString(15));
            address.setNumber(r.nextInt(5));

            bigObject.setAddress(address);

            list.add(bigObject);
        }

        return list;
    }



}
