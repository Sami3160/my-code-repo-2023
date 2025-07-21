#!/usr/bin/bash

DATA_DIR="$HOME/.local/share/mytodo"
mkdir -p $DATA_DIR
DATA_FILE="$DATA_DIR/data.csv"
USER_FILE="$DATA_DIR/user.txt"
name=""
password=""
if [ ! -n "$1" ]; then
    echo "Not enough arguments!"
    return 0;
fi
# if [ ! -e "$USER_FILE" ] || [ ! -s "$USER_FILE" ]; then
#     touch $USER_FILE
#     # echo "Register urself"
#     while true;do
#         read -p "Please enter your name: " name
#         name=$(echo -n "$name" | sed 's/^ *//;s/ *$//');
#         if [ -n "$name" ]; then
#             break
#         fi
#         echo "Error: Name should not be empty"
#     done
#     while true;do
#         read -p "Please enter your password: " password
#         password=$(echo -n "$password" | sed 's/^ *//;s/ *$//');
#         if [ -n "$password" ]; then
#             break
#         fi
#             echo "Error: Password should not be empty"
#     done
#     # name=$("echo $name" | sed -e 's/^[[:space:]]*//' -e 's/[[:space:]]*$//')
#     # password=$("echo $password" | sed -e 's/^[[:space:]]*//' -e 's/[[:space:]]*$//')
#     password=$(sha1sum <<< $password)
#     echo "$name $password" > "$USER_FILE"
#     # echo "Enter your name"
#     echo "User created!"
#     echo "Welcome $name"
# fi
if [ ! -e "$DATA_FILE" ]; then
    touch $DATA_FILE
    echo "id,title,description,date,status" >> $DATA_FILE;
fi

case "$1" in
    "-t")
        title=$(echo -n "$2" | sed 's/^ *//;s/ *$//');
        description=$(echo -n "$4" | sed 's/^ *//;s/ *$//');
        if [ ! -n "$title" ];then
            echo "Error: Empty title not allowed"
            return 0;
        fi
        if [ "$3" == "-d" ] && [ ! -n "$description" ];then
            echo "Error: Empty Desciption"
            return 0;
        fi
        date=$(date)
        id=$(sha1sum <<< $date | cut -c 1-6)
        echo -e "$id,$title,$description,$date,pending" >> $DATA_FILE
    ;;
    "-d")

        title=$(echo -n "$4" | sed 's/^ *//;s/ *$//');
        if [ "$3" != "-t" ] || [ ! -n "$title" ];then
            echo "Error: Empty Title"
            return 0;
        fi
        title="$4"

        description=$(echo -n "$2" | sed 's/^ *//;s/ *$//');
        if [ "$1" == "-d" ] && [ ! -n "$description" ];then
            echo "Error: Empty Desciption"
            return 0;
        fi

        date=$(date)
        id=$(sha1sum <<< $date | cut -c 1-6)
        echo -e "$id,$title,$description,$date,pending" >> $DATA_FILE

    ;;
    "-ls")
        filter=""
        if [ $(cut -c 1-6 <<< "$2") == "--sort" ]; then
            filter=$(cut -c 7- <<< "$2")
            case $filter in 
                "status")
                ;;
                "title")
                ;;
                "date")
                ;;
                *)
                echo "Error: Invalid --sort argument value"
                return 0
                ;;
            esac
        fi
    cat $DATA_FILE | column -t -s ,
    ;;
    "-rm")
    ;;
    "--clear-all")
        read -p "Password needed for clear all " password
        ;;
    *)
    echo "yohoho"
    ;;
esac


