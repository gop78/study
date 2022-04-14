# error: failed to push some refs to 에러

- 원인: github 저장소에 있는 파일이 내 local에는 파일이 없을 때 나타나는 에러
    - 내 상황은 commit → push를 하여 local과 github의 저장소가 일치하지 않은 상황에서 push를 하여 발생
    - 정상 적인 commit: add→ commit → push 순서로 github에 commit 진행

- 해결방법: 원격 저장소에 있는 파일을 pull 명령어를 사용하여 local로 가져와야 한다.
    
    ```markdown
    - git pull {원격저장소별칭} master
    - pull 이후 add → commit → push 순서로 commit 진행
    ```