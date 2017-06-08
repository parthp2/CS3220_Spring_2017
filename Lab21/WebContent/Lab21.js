//Answer1

function min(a,b,c,d,e)
{
    if(a==null && b==null && c==null && d==null && e==null)
    {
        return null;
    }
   	else
    {
        var m;
        
       	m=Math.min(a,b,c,d,e);
    	return m;
    }
}

function min(a,b,c,d,e)
{
	
	var array=[a,b,c,d,e];
	var min;

    if(a==null && b==null && c==null && d==null && e==null)
    {
        return null;
    }
	
   	else
    {
		min=array[0];
        for(var i=0;i<array.length-1;i++)
		{
				if(min>array[i])
				{
					min=array[i];
				}
		}
		
		return min;
    }
}

console.log(min(1,2,3,4,5));

//Answer2

var c=' ';
    
for(var i=1;i<8;i++)
{
    c= c+ '*';
    console.log(c);
}

//Answer3

function countBs(string)
{
    var b='B';
	var count=0;
    for(var i=0;i<string.length;i++)
    {
        if(string.charAt(i)=='B')
        {
            count++;
        }
    }
    return count;
}

function countChar(string,letter)
{
    var count=0;
    
    for(var i=0;i<string.length;i++)
    {
        if(string.charAt(i)==letter)
        {
            count++;
        }
    }
   
    return count;
}

console.log(countBs("BBC"));

console.log(countChar("kakkerlak", "k"));


//Answer 4

function reverseArray(a)
{
    var result=[];
    
    for(var i=a.length-1;i>=0;i--)
    {
        result.push(a[i]);
    }
    
    return result;
    
}

console.log(reverseArray(['A','B','C']))

function reverseArrayInPlace(a)
{
	var l=a.length;
	
    for(var i=0;i<Math.floor(l/2);i++)
    {
        var j=a[i];
		a[i]=a[l-i-1];
		a[l-i-1]=j;
    }
    
    return a;
    
}

var arrayValue=[1,2,3,4,5];

reverseArrayInPlace(arrayValue);

console.log(arrayValue);

//Answer 5;


function deepEqual(o1, o2)
{

  var a=0, b=0;
	
  if (o1 === o2)
  {
	  return true;
  }
  
  if (o1 === null || o2 === null || typeof o1 !== 'object' || typeof o2 !== 'object')
  {
    return false;
  }
   
  for (var c in o1) 
  {
     a=a+1;
  }
  for (var c in o2)
  {
	 b=b+1;
    if (!(c in o1) || !deepEqual(o1[c], o2[c]))
	{
      return false;
	}
  }
   
  return a === b;
};

var obj = {here: {is: "an"}, object: 2};
console.log(deepEqual(obj, obj));

console.log(deepEqual(obj, {here: 1, object: 2}));

console.log(deepEqual(obj, {here: {is: "an"}, object: 2}));
