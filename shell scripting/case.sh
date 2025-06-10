#!/bin/bash
case $1 in 
    sami | admin )
    echo "SUCCESSS: hello $1!! how are you"
    ;;
    help )
    echo "TIP: you need to enter name"
    ;;
    *)
    echo "ERROR: bye"
    ;;
esac