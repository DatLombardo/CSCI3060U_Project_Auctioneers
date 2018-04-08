#!/bin/bash
[ -e 'testRun/dayRecord.txt' ] && rm testRun/dayRecord.txt 
cd front
make clean
make
cd ..
declare -i place
place=0
for file in ./testRun/day/inputs/*
do
    echo "front $file"
    touch "testRun/day/outputs/out"$place".txt"
    cd front
    ./auctionHouse  < "../$file" > "../testRun/day/outputs/out"$place".txt"
    cd ..
    place=place+1
done
rm testRun/day/dayRecord.txt
for file in front/files/record/*
do
    cat $file >> testRun/day/dayRecord.txt
    echo "merge $file"
done

rm front/files/record/*

#cat testRun/day/dayRecord.txt
#cat front/files/itemList.txt
#cat front/files/userList.txt

cd main
make compile
rm ../testRun/dayOut.txt
java -cp ./junit-4.12.jar:./hamcrest-core-1.3.jar:. Backend transactionFile.txt userlist.txt itemlist.txt > ../testRun/dayOut.txt
echo "daily update"
cd ..
