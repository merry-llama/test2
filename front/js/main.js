async function sleep(msec) {
  return new Promise(resolve => setTimeout(resolve, msec));
}

async function checkList(){
    ResetList();
    document.getElementById("btnCheck").disabled = true;
   
    let li = document.querySelectorAll('.list-group li');
    for (let i = 0, len = li.length; i < len; i++) {   
      li[i].firstElementChild.classList.add('active');  
      let delay = getRandomIntInclusive(1,5) * 1000;

      await sleep(delay);

      var checkResult = Math.random() >= 0.5;
        if (checkResult){
          li[i].firstElementChild.src = "img/checked.png";
        }else{
          li[i].firstElementChild.src = "img/cancel.png";
        }
        li[i].firstElementChild.classList.remove('active');       
    }
    document.getElementById("btnCheck").disabled = false;
    
 }

function ResetList(){
  let li = document.querySelectorAll('.list-group li');
  for (let i = 0, len = li.length; i < len; i++) {  
    li[i].firstElementChild.src = "img/gear.png";
  }
} 

function getRandomIntInclusive(min, max) {
    min = Math.ceil(min);
    max = Math.floor(max);
    return Math.floor(Math.random() * (max - min + 1)) + min; 
}

