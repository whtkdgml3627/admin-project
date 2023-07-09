//댓글 비동기통신처리
//list
const getList = async(page) => {
  const res = await axios.get(`${realPath}/replies/${bno}/list?page=${page}`)
  return res.data
}

//register
const postRegister = async(data) => {
  const res = await axios.post(`${realPath}/replies/${bno}/register`, data)
  return res.data
}

//list 함수로 선언
const getListDefault = (page) => {
  getList(page).then(arr => {
    let replyStr = ""
    let replyPagingStr = ""
    console.log(arr)
    for(let i = 0; i < arr.list.length; i++){
      const {reply, replyer, replyDate, step, gno} = arr.list[i]
      replyStr += `
        <div class="d-flex align-items-center py-3 border-top${step === 0 ? "" : " ps-3"}">
          <div class="w-100">
            <div class="d-flex w-100 justify-content-between">
              <h6 class="mb-0">${reply}</h6>
            </div>
            <span>${replyer}</span>
            <small class="mx-3">${replyDate}</small>
            <button class="btn btn-outline-secondary" data-reply="reply" data-gno="${gno}">Reply</button>
          </div>
        </div>
      `
    }

    const {page, startNum, endNum, prevBtn, nextBtn, total} = arr

    prevBtn === true ? replyPagingStr += `<li><button data-page="${startNum - 1} class="btn btn-primary"><</button></li>` : ""

    for(let i = startNum; i <= endNum; i++){
      replyPagingStr += `
        <li${page === i ? " class='active'" : ''}>
          <button data-page="${i}" class="btn btn-primary">${i}</button>
        </li>
      `
    }

    nextBtn === true ? replyPagingStr += `<li><button data-page="${endNum + 1} class="btn btn-primary">></button></li>` : ""
    replyPagingStr += `<input type="hidden" name="replyEndNum" value="${endNum}">`

    //console.log(replyStr)
    //console.log(replyPagingStr)
    replyWrap.innerHTML = replyStr
    replyPaging.innerHTML = replyPagingStr
  })
}