arr=(1 2 3 4 5)

echo "looping 1 with array expansion"   
for i in ${arr[@]} ; do
    echo $i
done


echo "looping 2 with numbers"   
for i in 1 2 3 4 5 ; do
    echo $i
done


echo "looping 3 with strings"   
for i in hello world, how are you ; do
    echo $i
done


echo "looping 4 with seq"   
for i in $(seq 1 10) ; do
    echo $i
done