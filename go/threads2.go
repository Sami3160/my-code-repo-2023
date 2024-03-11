package main
import (

	"fmt"
	"time"
	"sync"
)

func main(){
	var wg sync.WaitGroup				//the WaitGroup helps to make program wait for goroutines
	// go func(){				
		
		// }()
	wg.Add(1)		//means only 1 go routine will be cretaed
	go printNum(&wg)
	wg.Add(1)
	go printChar(&wg)
	// time.Sleep(1500*time.Millisecond)

	wg.Wait()
	
}


func printNum(wg *sync.WaitGroup){
	defer wg.Done()
	for i:=1;i<=10;i++{
		fmt.Print(i)
		time.Sleep(100*time.Millisecond)
	}
}

func printChar(wg *sync.WaitGroup){
	defer wg.Done()
	for i:='a';i<='j';i++{
		fmt.Printf("%c",i)
		time.Sleep(100*time.Millisecond)

	}
}