# git

# 如何解决error: failed to push some refs to 'xxx(远程库)'

出现错误的主要原因是远程库中中的README.md文件不在本地代码目录中 

可以通过如下命令进行代码合并【注：pull=fetch+merge]】

 `git pull –rebase origin master` 

再`git push -u origin master` 