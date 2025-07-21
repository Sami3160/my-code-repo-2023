arr=(1 2 3 4 5)

echo "all elements ${arr[@]}"  # shows all elements
echo "firts index ${arr[0]} "  # shows one element
echo "second index ${arr[1]} "  # shows second element
echo "length ${#arr[@]}"   # shows length
echo "looping"   
for i in ${arr[@]} ; do
    echo $i
done