---
title: GitHub笔记
categories: GitHub
tags: Git
---



# Git基本操作

#### 创建版本库

安装好git后,打开git,输入:

> $ git config --global user.name "Your Name"
>
> $ git config --global user.email "email@example.com"



创建文件夹

> mkdir name(文件夹名字 )



初始化库,里面会生成.git隐藏文件夹

> git init



上传到本地库中（这里用的案例用readme.txt） 

>git add readme.txt(将文本上传到本地暂存库库)
>
>git status(查看上传的状态)***随时掌握库的状态
>
>git commit -m "first"
>
>(提交到本地库,'first'为注释，当上传项目到github时，作用是标注我上传该项目时的想法)



上传一个必备文件README.md ，这个文件是在每次初次上传项目文件时都需要必备的

> touch README.md (这是windows下的命令.新建文件)
>
> git add README.md



查看文件内容`cat readme.txt`

---







#### 版本回退

版本1：wrote a readme file

> Git is a version control system.
>
> Git is free software.

版本2：add distributed

> Git is a distributed version control system.
>
> Git is free software.


版本3：append GPL

> Git is a distributed version control system.
>
> Git is free software distributed under the GPL.



日志查看`git log`

> $ git log
> commit 1094adb7b9b3807259d8cb349e7df1d4d6477073 (HEAD -> master)
> Author: 
> Date:   
>
> ​	append GPL
>
> commit e475afc93c209a690c39c13a46716e8fa000c366
> Author: 
> Date:   
>
> ​	add distributed
>
> commit eaadf4e385e865d25c48e7ca9c8395c3f7dfaef0
> Author:
> Date:   
>
> wrote a readme file



简化日志`git log --pretty=oneline `,更简洁`git log --oneline`

> $ git log --pretty=oneline1094adb7b9b3807259d8cb349e7df1d4d6477073 (HEAD -> master) append GPLe475afc93c209a690c39c13a46716e8fa000c366 add distributedeaadf4e385e865d25c48e7ca9c8395c3f7dfaef0 wrote a readme file

`HEAD`是指针,它指向哪,版本就在哪.`1094adb7...`是哈希算法生成的.



回退操作

* 基于索引值`git reset -hard 1094adb7`
* 基于^和~符号`git reset -hard HEAD^`只能回退,回退多个`git reset -hard HEAD~n`



小结

- `HEAD`指向的版本就是当前版本，因此，Git允许我们在版本的历史之间穿梭，使用命令`git reset --hard commit_id`。

- 穿梭前，用`git log`可以查看提交历史，以便确定要回退到哪个版本。

- 要重返未来，用`git reflog`查看命令历史，以便确定要回到未来的哪个版本。
---
  

#### 远程库

##### 生成SSH公钥关联

在库文件夹下输入:

> $ cd ~/.ssh
>
> $ ls
> authorized_keys2  id_dsa       known_hosts
> config            id_dsa.pub



看一下有没有id_rsa和id_rsa.pub(或者是id_dsa和id_dsa.pub之类成对的文件)，有 .pub 后缀的文件就是公钥，另一个文件则是密钥。

假如没有这些文件，甚至连 .ssh 目录都没有，可以用 ssh-keygen 来创建。该程序在 Linux/Mac 系统上由 SSH 包提供，而在 Windows 上则包含在 MSysGit 包里： 

> $ ssh-keygen -t rsa -C "your_email@youremail.com"
>
> Creates a new ssh key using the provided email # Generating public/private rsa key pair.
>
> Enter file in which to save the key (/home/you/.ssh/id_rsa):



直接按Enter就行。然后，会提示你输入密码，如下 

> Enter same passphrase again: [Type passphrase again]



完了之后，大概是这样：

> Your public key has been saved in /home/you/.ssh/id_rsa.pub.
> The key fingerprint is: # 01:0f:f4:3b:ca:85:d6:17:a1:7d:f0:68:9d:f0:a2:db your_email@youremail.com



查看生成的公钥

> $ cat ~/.ssh/id_rsa.pub ssh-rsa AAAAB3NzaC1yc2EAAAABIwAAAQEAklOUpkDHrfHY17SbrmTIpNLTGK9Tjom/BWDSU GPl+nafzlHDTYW7hdI4yZ5ew18JH4JW9jbhUFrviQzM7xlELEVf4h9lFX5QVkbPppSwg0cda3 Pbv7kOdJ/MTyBlWXFCR+HAo3FXRitBqxiX1nKhXpHAZsMciLq8V6RjsNAQwdsdMFvSlVK/7XA t3FaoJoAsncM1Q9x5+3V0Ww68/eIFmb1zuUFljQJKprrX88XypNDvjYNby6vw/Pb0rwert/En mZ+AW4OZPnTPI89ZPmVMLuayrD2cE86Z/il8b+gw3r3+1nKatmIkjn2so1d01QraTlMqVSsbx NrRFi9wrf+M7Q== schacon@agadorlaptop.local 



##### 添加公钥到远程仓库（github)

登陆你的github帐户。点击你的头像，然后 `Settings -> 左栏点击 SSH and GPG keys -> 点击 New SSH key`

然后你复制上面的公钥内容，粘贴进“Key”文本域内。 title域，自己随便起个名字。

点击 Add key。

完成以后，验证下这个key是不是正常工作：

> $ ssh -T git@github.comAttempts to ssh to github

如果看到

> Hi xxx! You've successfully authenticated, but GitHub does not # provide shell access.

设置成功

---


##### 修改git的remote url

使用命令` git remote -v `查看当前的 remote url 

> ```
> $ git remote -v
> origin https://github.com/someaccount/someproject.git (fetch)
> origin https://github.com/someaccount/someproject.git (push)```



改为ssh协议

> git remote add origin git@github.com:someaccount/someproject.git



再用`git remote -v`查看



##### 远程库操作

* 克隆远程库

> git clone git@github.com:Young-3/project.git

* 关联远程库


> git remote add origin git@github.com:Young-3/project.git


添加后，远程库的名字就是`origin`，这是Git默认的叫法，也可以改成别的，但是`origin`这个名字一看就知道是远程库。 

* 把本地库的所有内容推送到远程库上 

> git push -u origin master