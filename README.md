# INFO_6205_FinalProject_Maven
maven struct

## New Model
All test(we use test as our main run method).

TXT read model to read txt file on disk.

MingZI model to storage and use for sort.

GenerateName model to generate Chinese name randomly, use to test sort result.

ChineseCharToEn model base on PinYin4j, transform Chinese character to English according to pinyin.

Benchmark model to test time duration of sort. MyHuskySortBenchmark Special customized benchmark for husky sort.

## Changes on existing code
Modify TImsort, LSDSort, MSDSort, QuickSort and Huskysort to our structure.

Replace default Collator for Huskysort with IBM Collator, make it suitable for more Chinese characters.
