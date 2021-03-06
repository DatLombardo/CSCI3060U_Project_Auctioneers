#!/bin/bash
#tell us which day we want to run through
day_num=$1
[ -e 'testRun/dayRecord.txt' ] && rm testRun/dayRecord.txt

#step 1 run the front end over each input
#store eachout in an internal folder
itemlist="front/files/itemList.txt"
userlist="front/files/userList.txt"
transaction_outputs="front/files/record/"

rm $transaction_outputs*

merge_out_file="testRun/day/outputs/daily/merged_daily_out_file$day_num.txt"
echo run day inputs $day_num

#run through every input for a day

#merged_input="testRun/day/inputs/day$day_num/merged_inputs_day$day_num.txt"
#clear this file
# > $merged_input

#all transactions to be ran in one file
# cd "./testRun/day/inputs/day$day_num/"
# cat * > "merged_inputs_day$day_num.txt"
# cd ../../../../
cd front
for file in ../testRun/day/inputs/day$day_num/*
do
    echo $file
    ./auctionHouse < "$file" > a.txt
    rm a.txt
done
cd ..

cd  ./testRun/day/inputs/day$day_num/
  rm ../merged_inputs_day$day_num.txt
  cat *.txt >> ../merged_inputs_day$day_num.txt
cd  ../../../..



#merge all transactions for the day
cd $transaction_outputs
cat *.txt> "../../../$merge_out_file"
cd ../../../


echo $day_num front end finished
echo $day_num backend start

#run the backend to update user and item file
cd main
make compile
java Backend "../"$merge_out_file "../"$userlist "../$itemlist" > a.txt
rm a.txt
echo "daily update"
cd ..

echo $day_num backend finished
#FINAL OUTPUT
#we have a merged set of inputs
#a merged set of transactions
#an updated item and userfile
#all of this for a day
