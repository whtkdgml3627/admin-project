//파일 보여주기
const showProducts = (arr) => {
  let str = ""
  for (const uploadFile of arr){
    //console.log(uploadFile)
    //구조 분해 할당
    const {fileName,link,uuid} = uploadFile
    console.log(uploadFile)
    str += `
        <li data-originName="${uuid}_${fileName}">
          <a href="http://localhost/${uuid}_${fileName}" target="_blank">
            <img src="http://localhost/${link}"/>
          </a>
          <p>${fileName}</p>
          <button class="btn btn-danger" onclick="javascript:removeFile(event, '${uuid}', '${fileName}')">X</button>
        </li>`
  }
  //여러번 업로드 할 수 있으니 +=로 계속 추가
  uploadUL.innerHTML += str
}

//파일 삭제
const removeFile = (e, uuid, fileName) => {
  e.preventDefault()
  e.stopPropagation()

  const liObj = e.target.closest("li")
  //console.log(liObj)
  let originFile = ""
  fileName !== undefined ? originFile = uuid + "_" + fileName : originFile = uuid

  //console.log(originFile)

  //nginx 파일 삭제
  axios.delete(`http://localhost:8080/api/files/remove/${originFile}`)

  //li 삭제
  liObj.remove()
}