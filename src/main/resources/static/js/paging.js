//paging 함수 생성
function makePages(page, size, total){

  //페이징 버튼 생성 변수
  let pagingResult = ""

  //페이징 첫번째 번호
  //현재페이지 / 10 한 후 올림처리
  //10을 곱해줘서 구한다음 -9를 해주기
  const startNum = (Math.ceil(page / 10) * 10) - 9
  //console.log("페이지 시작 번호 : ", startNum);

  //시작번호가 1번이면 이전버튼 노출 안되게
  startNum !== 1 ? pagingResult += `<a href="${startNum - 1}" class="btn btn-primary"><</a>` : ""

  //페이징 번호 변수
  let temp = startNum

  //페이징 버튼 동적 생성 / while(true)
  while(true){
    //페이징번호 * size 이 total보다 크면 break
    if(temp * size > total) {
      if(total % (Math.ceil(page / 10) * (10 * size)) !== 1){
        temp == page ? pagingResult += `<a href="${temp}" class="btn btn-primary active">${temp}</a>` : pagingResult += `<a href="${temp}" class="btn btn-primary">${temp}</a>`
      }
      break
    }
    //page와 temp가 같으면 active 처리
    temp === page ? pagingResult += `<a href="${temp}" class="btn btn-primary active">${temp}</a>` : pagingResult += `<a href="${temp}" class="btn btn-primary">${temp}</a>`
    //pagingResult += `<a href="${temp}" class="btn btn-primary">${temp}</a>`;
  
    temp++
  }

  //total이 size*10 을 나눈 나머지가 1이면 노출
  total % (Math.ceil(page / 10) * (10 * size)) === 1 ? pagingResult += `<a href="${temp}" class="btn btn-primary">></a>` : ""
  //console.log("페이징 동적 생성 html : ", pagingResult);

  console.log(startNum, temp, total)
  //return으로 html 반환
  return pagingResult
}