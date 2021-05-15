# hadoop-training

## Spark Scala  Job Application 

### Run below command to execute Job Application
-	spark-submit --master localhost --class {main class} {path to jar directory}/{jar-name}.jar  paramter1 paramter2 paramter3  paramter4

- e.g. spark-submit --master localhost --class AdsRecommendation /home/chetan/workstation/workspace/IntelliJWorkspace/AdsRecommend/build/libs/AdsRecommend-1.0-SNAPSHOT.jar  file:///home/chetan/workstation/github/hadoop-training/final-assignment/input-data/min-clicks.json file:///home/chetan/workstation/github/hadoop-training/final-assignment/input-data/min-impressions.json file:///home/chetan/workstation/github/hadoop-training/final-assignment/3-scala/goal-2-calculate-metrics/metrics file:///home/chetan/workstation/github/hadoop-training/final-assignment/3-scala/goal-3-top-recommendation/recommendation