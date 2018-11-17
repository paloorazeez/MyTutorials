let jsonStr1='{"firstName":"John", "lastName":"Doe","sex":"Male","address":"Nilgiris","dob":"05-02-1987"}';
let jsonStr2='{"firstName":"John", "lastName":"Doe","age":28,"dob":"05-02-1988"}';
class KeyValuePair{
    keyStr:string;
    valueObj:Object;
    constructor(keyStr,valueObj)
    {
        this.keyStr =keyStr;
        this.valueObj= valueObj;
    }

}

class ResultJson{
    matchedArr:any[];
    conflictArr:any[];
    extraValsArr:any[];
    constructor(matchedArr,conflictArr,extraValsArr)
    {
        this.matchedArr = matchedArr;
        this.conflictArr = conflictArr;
        this.extraValsArr = extraValsArr;
    }
}


let result = compareJsonString(jsonStr1,jsonStr2);
console.log(result);

function compareJsonString(jsonStr1, jsonStr2)
{

    let jsonOb1 = JSON.parse(jsonStr1); 
    let jsonOb2 = JSON.parse(jsonStr2); 
    let keysOb1  = Object.keys(jsonOb1);
    let keysOb2  = Object.keys(jsonOb2);
    let matchedArr:KeyValuePair[] = new Array();
    let conflictArr:KeyValuePair[] = new Array();
    let extraValuesArr:KeyValuePair[] = new Array();
    if(keysOb1 && keysOb1.length>0 && keysOb2 && keysOb2.length>0)
    {
        for(let entry of keysOb1)
        {
           if(jsonOb1[entry]===jsonOb2[entry]){
            matchedArr.push(new KeyValuePair(entry,jsonOb1[entry]));
           }
           else if(jsonOb2[entry] !== undefined)
           {
                let arr = [jsonOb1[entry],jsonOb2[entry]];
                conflictArr.push(new KeyValuePair(entry,arr));
           }
           else{
               //let arr = [jsonOb1[entry],jsonOb2[entry]];
               extraValuesArr.push(new KeyValuePair(entry,jsonOb1[entry]));
               //conflictArr.push(new KeyValuePair(entry,jsonOb2[entry]));

           }
        }

        var excessInKey2 = keysOb2.filter(function(key){
            return keysOb1.indexOf(key) === -1;
        });

       // console.log(excessInKey2);
        
        if(excessInKey2 && excessInKey2.length>0)
        {
            for(let key of excessInKey2)
            {
                extraValuesArr.push(new KeyValuePair(key,jsonOb2[key]));
            }
        }

    }
    let result = new ResultJson(matchedArr,conflictArr,extraValuesArr);
    //console.log(result);

    //console.log(extraValuesArr);
    return JSON.stringify(result);
    
    
}
