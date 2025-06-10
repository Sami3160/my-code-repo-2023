#!/usr/bin/bash
# if [ "$1" = "sami" ];then
#     echo "hello"
# elif [ "$1" = "help" ]; then
#     echo "enter name"
# else
#     echo "bye"

# fi


if [ "${1,,}" = "sami" ];then
    echo "hello"
elif [ "${1,,}" = "help" ]; then
    echo "enter name"
else
    echo "bye"

fi

