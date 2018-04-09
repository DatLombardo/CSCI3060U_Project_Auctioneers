#!/bin/bash
cd front
make clean
make
cd ..

cd main
make compile
cd ..
#run the daily script 5 times
itemlist="front/files/itemList.txt"

for i in {1..5}
do
  ./day.sh $i
done

echo weekly transactions finished

echo avilable item list:
cat $itemlist
