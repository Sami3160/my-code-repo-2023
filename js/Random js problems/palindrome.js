function isPalindrome(str,beg=0,end=str.length-1) {
  
  if(beg>end||beg==end){
    return true;
  }  
  if(beg!=end && str[beg]==str[end]){
      return isPalindrome(str,beg+1,end-1);
    }
}
isPalindrome('nitin')==true?console.log("palindome"):console.log("not palindome");
module.exports = isPalindrome;
