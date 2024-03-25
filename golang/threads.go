package main
import (

	"fmt"
	"time"
)

func main(){
	go printNum()
	go printChar()
	time.Sleep(1500*time.Millisecond)
	
}


func printNum(){
	for i:=1;i<=10;i++{
		fmt.Print(i)
		time.Sleep(100*time.Millisecond)
	}
}

func printChar(){
	for i:='a';i<='j';i++{
		fmt.Printf("%c",i)
		time.Sleep(100*time.Millisecond)

	}
}