echo "Please select question (1/2/3)"
read  num

if [[ $num == 1 ]]
then
	print "the number is 1"
	read -p "please enter 2 variables" arg1 arg2
	arg1=$1
	arg2=$2
	r=$((arg1 + arg2))

	if ! [[ $r -eq 100 ]]
	then 
	echo "it is smaller or greater"
	fi
elif [[ $num == 2 ]]
then
	read -p "enter degree" arg
	arg=$((arg -32))
	arg=$( echo "$arg/1.8" | bc )
	echo "the degree is $arg"
elif [[ $num == 3 ]]
then
	du | sort -k1nr | head -10
else
echo"wrong number"
fi
