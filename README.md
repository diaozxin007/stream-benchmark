
```
Benchmark                     (length)  Mode  Cnt  Score   Error  Units
IntTest.minIntFor                10000  avgt    2  0.008          ms/op
IntTest.minIntFor               100000  avgt    2  0.075          ms/op
IntTest.minIntFor              1000000  avgt    2  1.589          ms/op
IntTest.minIntParallelStream     10000  avgt    2  0.047          ms/op
IntTest.minIntParallelStream    100000  avgt    2  0.311          ms/op
IntTest.minIntParallelStream   1000000  avgt    2  3.582          ms/op
IntTest.minIntStream             10000  avgt    2  0.092          ms/op
IntTest.minIntStream            100000  avgt    2  0.720          ms/op
IntTest.minIntStream           1000000  avgt    2  8.591          ms/op
```

```
Benchmark                        (length)  Mode  Cnt   Score   Error  Units
BigObjectTest.minFor                10000  avgt    2   0.036          ms/op
BigObjectTest.minFor               100000  avgt    2   1.580          ms/op
BigObjectTest.minFor              1000000  avgt    2  28.427          ms/op
BigObjectTest.minParallelStream     10000  avgt    2   0.047          ms/op
BigObjectTest.minParallelStream    100000  avgt    2   0.916          ms/op
BigObjectTest.minParallelStream   1000000  avgt    2  23.721          ms/op
BigObjectTest.minStream             10000  avgt    2   0.129          ms/op
BigObjectTest.minStream            100000  avgt    2   2.080          ms/op
BigObjectTest.minStream           1000000  avgt    2  31.037          ms/op
```

```
Benchmark                      (length)  Mode  Cnt   Score   Error  Units
ComplexTest.minFor                10000  avgt    2   0.437          ms/op
ComplexTest.minFor               100000  avgt    2   9.189          ms/op
ComplexTest.minFor              1000000  avgt    2  90.578          ms/op
ComplexTest.minParallelStream     10000  avgt    2   0.067          ms/op
ComplexTest.minParallelStream    100000  avgt    2   1.154          ms/op
ComplexTest.minParallelStream   1000000  avgt    2  13.310          ms/op
ComplexTest.minStream             10000  avgt    2   0.178          ms/op
ComplexTest.minStream            100000  avgt    2   4.534          ms/op
ComplexTest.minStream           1000000  avgt    2  47.878          ms/op
```

add for2 
```
Benchmark                      (length)  Mode  Cnt   Score   Error  Units
ComplexTest.minFor                10000  avgt    2   0.348          ms/op
ComplexTest.minFor               100000  avgt    2   7.464          ms/op
ComplexTest.minFor              1000000  avgt    2  89.096          ms/op
ComplexTest.minFor2               10000  avgt    2   0.152          ms/op
ComplexTest.minFor2              100000  avgt    2   3.178          ms/op
ComplexTest.minFor2             1000000  avgt    2  38.346          ms/op
ComplexTest.minParallelStream     10000  avgt    2   0.064          ms/op
ComplexTest.minParallelStream    100000  avgt    2   0.994          ms/op
ComplexTest.minParallelStream   1000000  avgt    2  10.020          ms/op
ComplexTest.minStream             10000  avgt    2   0.172          ms/op
ComplexTest.minStream            100000  avgt    2   3.609          ms/op
ComplexTest.minStream           1000000  avgt    2  45.379          ms/op
```

boxing

```
Benchmark                      (length)  Mode  Cnt   Score   Error  Units
ComplexTest.minFor                10000  avgt    2   0.367          ms/op
ComplexTest.minFor               100000  avgt    2   6.728          ms/op
ComplexTest.minFor              1000000  avgt    2  78.489          ms/op
ComplexTest.minFor2               10000  avgt    2   0.157          ms/op
ComplexTest.minFor2              100000  avgt    2   3.264          ms/op
ComplexTest.minFor2             1000000  avgt    2  40.124          ms/op
ComplexTest.minParallelStream     10000  avgt    2   0.074          ms/op
ComplexTest.minParallelStream    100000  avgt    2   1.033          ms/op
ComplexTest.minParallelStream   1000000  avgt    2  12.098          ms/op
ComplexTest.minStream             10000  avgt    2   0.164          ms/op
ComplexTest.minStream            100000  avgt    2   4.179          ms/op
ComplexTest.minStream           1000000  avgt    2  43.956          ms/op
```