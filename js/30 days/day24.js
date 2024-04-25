/**
 * @param {Object|Array} obj
 * @return {Object|Array}
 */
var compactObject = function (obj) {
    // if (!Array.isArray(obj)) obj = Object.values(obj);
    if (Array.isArray(obj)) {
            
        obj.map((i) => {
            if (i == false || i == null ) {
                console.log(i);
                obj.splice(obj.indexOf(i), 1)
            }
            if (typeof i == 'object') {
                i = compactObject(i)
            }
        })
    } else if (typeof obj == 'object') {
        Object.keys(obj).map((i) => {
            if (obj[i] == false || obj[i] == null ) {
                // obj[i]
                delete obj[i]
            }
            if (typeof obj[i] == 'object') {
                // delete obj[i]
                obj[i] = compactObject(obj[i])
                // obj[i]
            }
        })
    }

    return obj;
};


console.log(compactObject([[false, 16]]))