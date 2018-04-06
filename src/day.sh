#!/bin/bash
[ -e 'testRun/dayRecord.txt' ] && rm testRun/dayRecord.txt 
cd front
make
cd ..
declare -i place
place=0
for file in ./testRun/day/inputs/*
do
    front/auctionHouse < $file > "testRun/day/outputs/out"$place".txt"
    place=place+1
done
for file in ./testRun/day/outputs/*
do
    cat $file >> testRun/day/dayRecord.txt
done

cd main
make compile
java -cp ./junit-4.12.jar:./hamcrest-core-1.3.jar:. Backend transactionFile.txt userlist.txt itemlist.txt
cd ..