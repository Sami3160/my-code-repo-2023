my_array=("smai" "maaj" "arron" "malya" "pruth")

for item in ${my_array[@]}; do
  echo $item
done

echo -e
for i in ${!my_array[@]}; do
  echo ${my_array[$i]} $i
done