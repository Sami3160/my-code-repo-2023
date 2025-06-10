#!/bin/bash
helloworld(){
    echo $1
}
# helloworld echo


fun1(){
    cat << EOF
    wassup buddy
    this is func
    with multiline
    byeee <3
EOF
}


a=10
fun2(){
    local a=20
    echo local a $a
}
fun2
echo global a $a 
# fun1