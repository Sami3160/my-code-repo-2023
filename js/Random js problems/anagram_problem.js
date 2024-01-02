function isAnagram(str1, str2) {
    let f = 1;

    for (let i = 0; i < str1.length; i++) {
        if (str2.indexOf(str1[i]) == -1) {
            f = 0
            break;
        }
    }
    return (f == 1 ? true : false)
}

module.exports = isAnagram;