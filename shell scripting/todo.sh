#!/usr/bin/bash

DATA_DIR="$HOME/.local/share/mytodo"
mkdir -p $DATA_DIR
DATA_FILE="$DATA_DIR/data.csv"
USER_FILE="$DATA_DIR/user.txt"
name="samii"
password="1234"
if [ ! -n "$1" ]; then
    echo "Not enough arguments!"
    return 0;
fi
 echo "Welcome $name"
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
    #new listing logic
   "-ls")
        sort_key=""
        if [[ "$2" == --sort=* ]]; then
            sort_field=$(echo "$2" | cut -d'=' -f2)
            case "$sort_field" in
                "status") sort_key=5 ;;
                "title") sort_key=2 ;;
                "date") sort_key=4 ;;
                *)
                    echo "Error: Invalid --sort argument value. Use 'status', 'title', or 'date'."
                    exit 1
                ;;
            esac
            (head -n 1 "$DATA_FILE" && tail -n +2 "$DATA_FILE" | sort -t, -k"$sort_key") | column -t -s,
        else
            cat "$DATA_FILE" | column -t -s,
        fi
    ;;
    "-rm")
    ;;
    "--clear-all")
        read -sp "Password needed to clear all tasks: " user_password
        echo
        if [ "$user_password" == "$password" ]; then
            head -n 1 "$DATA_FILE" > "$DATA_FILE.tmp" && mv "$DATA_FILE.tmp" "$DATA_FILE"
            echo "All tasks have been cleared."
        else
            echo "Incorrect password. Action aborted."
        fi
    ;;
    "--help")
        echo "Usage: mytodo [command] [options]"
        echo
        echo "Commands:"
        echo "  -t \"<title>\" [-d \"<description>\"]  Add a new task."
        echo "  -d \"<description>\" -t \"<title>\"  Add a new task (alternative order)."
        echo "  -ls [--sort=<field>]              List all tasks. Sort by 'status', 'title', or 'date'."
        echo "  -rm <ID>                          Remove a task by its ID."
        echo "  -u <ID> <new_status>              Update the status of a task (e.g., 'done', 'in-progress')."
        echo "  --clear-all                       Remove all tasks (requires password)."
        echo "  --help                            Show this help message."
        echo
        echo "Example:"
        echo "  mytodo -t \"Buy milk\" -d \"Get 2% milk from the store\""
        echo "  mytodo -ls --sort=status"
        echo "  mytodo -u f4c3d2 done"
    ;;
    *)
    echo "yohoho"
    ;;
esac


