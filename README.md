
|Benchmark|                     |(length)|  Mode|  Cnt|  Score|   Error|  Units|
|  ----  | ----  |  ----  | ----  |   ----  | ----  |----  |
|IntTest.minIntFor            |    10000|  avgt |   2 | 0.008 |        | ms/op|
|IntTest.minIntFor            |   100000|  avgt |   2 | 0.075 |        | ms/op|
|IntTest.minIntFor            |  1000000|  avgt |   2 | 1.589 |        | ms/op|
|IntTest.minIntParallelStream |    10000|  avgt |   2 | 0.047 |        | ms/op|
|IntTest.minIntParallelStream |   100000|  avgt |   2 | 0.311 |        | ms/op|
|IntTest.minIntParallelStream |  1000000|  avgt |   2 | 3.582 |        | ms/op|
|IntTest.minIntStream         |    10000|  avgt |   2 | 0.092 |        | ms/op|
|IntTest.minIntStream         |   100000|  avgt |   2 | 0.720 |        | ms/op|
|IntTest.minIntStream         |  1000000|  avgt |   2 | 8.591 |        | ms/op|

|Benchmark|                     |(length)|  Mode|  Cnt|  Score|   Error|  Units|
|  ----  | ----  |  ----  | ----  |   ----  | ----  |----  |
|BigObjectTest.minFor             |   10000 | avgt  |  2 |  0.036 |         |ms/op|
|BigObjectTest.minFor             |  100000 | avgt  |  2 |  1.580 |         |ms/op|
|BigObjectTest.minFor             | 1000000 | avgt  |  2 | 28.427 |         |ms/op|
|BigObjectTest.minParallelStream  |   10000 | avgt  |  2 |  0.047 |         |ms/op|
|BigObjectTest.minParallelStream  |  100000 | avgt  |  2 |  0.916 |         |ms/op|
|BigObjectTest.minParallelStream  | 1000000 | avgt  |  2 | 23.721 |         |ms/op|
|BigObjectTest.minStream          |   10000 | avgt  |  2 |  0.129 |         |ms/op|
|BigObjectTest.minStream          |  100000 | avgt  |  2 |  2.080 |         |ms/op|
|BigObjectTest.minStream          | 1000000 | avgt  |  2 | 31.037 |         |ms/op|

|Benchmark|                     |(length)|  Mode|  Cnt|  Score|   Error|  Units|
|  ----  | ----  |  ----  | ----  |   ----  | ----  |----  |
|ComplexTest.minFor             |   10000|  avgt |   2 |  0.437|         | ms/op|
|ComplexTest.minFor             |  100000|  avgt |   2 |  9.189|         | ms/op|
|ComplexTest.minFor             | 1000000|  avgt |   2 | 90.578|         | ms/op|
|ComplexTest.minParallelStream  |   10000|  avgt |   2 |  0.067|         | ms/op|
|ComplexTest.minParallelStream  |  100000|  avgt |   2 |  1.154|         | ms/op|
|ComplexTest.minParallelStream  | 1000000|  avgt |   2 | 13.310|         | ms/op|
|ComplexTest.minStream          |   10000|  avgt |   2 |  0.178|         | ms/op|
|ComplexTest.minStream          |  100000|  avgt |   2 |  4.534|         | ms/op|
|ComplexTest.minStream          | 1000000|  avgt |   2 | 47.878|         | ms/op|