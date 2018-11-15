---
title: Hexo搭建个人博客笔记
categories: Hexo
tags: GitHub hexo
---



# Hexo+github

## 搭建的过程分为以下几步：
1.	安装Node.js
2.	安装Git软件
3.	安装hexo博客框架
4.	测试本地运行（线下访问个人博客）
5.	部署到Coding以及GitHub上（线上访问个人博客）
6.	设置域名解析
7.	其他（写一篇新的博文，设置categories,tags）

### Node.js
Node.js下载地址：https://nodejs.org/en/download/
安装过程一路默认安装即可。

### 安装Git软件

Git软件下载地址：https://git-scm.com/download
安装过程一路默认安装即可。


----------


### 安装Hexo
什么是 Hexo？
Hexo 是一个快速、简洁且高效的博客框架。Hexo 使用 Markdown（或其他渲染引擎）解析文章，在几秒内，即可利用靓丽的主题生成静态网页。
Hexo官方网站：https://hexo.io/zh-cn/

#### **安装**
安装命令：
> sudo npm install -g hexo-cli  #-g表示全局安装

这里提一下：关于hexo的终端操作最好是在管理员模式下，读者可以采用按住Shift然后再点击鼠标右键选择弹出菜单的在此处打开Powershell窗口保证运行在管理员状态下。

初始化完成之后，因为会出现有些依赖包未安装成功的情况，所以请再输入以下命令安装依赖包:
> hexo install hexo --save  # 安装依赖包  

#### **初始化hexo**
在电脑合适的位置新建一个文件夹存放博客。本文中取名为Blog文件夹。
控制台命令行使用cd命令进入到Blog文件夹，输入以下命令进行初始化：
> hexo init  # 初始化 


#### **测试本地运行**
完成以上安装步骤后，便可以在本地预览博客效果了。
`启动服务(npm install -->hexo server -->hexo clean -->hexo generate -->hexo deploy)`
输入以下命令：
>hexo s   # 等同于hexo server，在本地服务器运行
hexo clean #清理缓存
hexo g   # 等同于hexo generate，生成静态文件
hexo d  #部署文件到github

然后打开浏览器地址栏输入：http://localhost:4000/便可以预览生成的博客框架雏形了。


----------

### 部署到GitHub 
#### **注册GitHub**
gitHub网址如下：http://www.github.com
部署到线上（GitHub）
配置文件要区分站点配置文件和主题配置文件，首先站点配置文件和主题配置文件名称都是一样的`_config.yml`，站点配置文件在网站根目录，主题配置文件在根目录下的theme文件的具体theme下的_config.yml。

#### **修改站点配置文件**
打开_config.yml到最后deploy选项： 
配置如下：
>  ```#Deployment
 ##Docs: https://hexo.io/docs/deployment.html
  #deploy:
  type: git
  repo: git@github.com:Young-3/young-3.github.io.git
  branch: master```
  
注意：每个冒号后面都是有一个空格的，这是node的语法。

#### **部署**
部署之前需要安装git部署插件，否则会提示Deployer not found错误。
> npm install hexo-deployer-git --save

安装完毕后控制台输入：
> hexo g -d   

随后访问你的以下网址（注意替换）：
>http//:yourName.github.io 

#### 域名
购买域名.然后到gitub上配置

#### 新建post
写一篇新的博文
两种方法： 
- 在博文根目录的Source文件夹的post文件夹下直接新建一个md文件 
- 在博文根目录打来PowerShell，然后输入`hexo new '你的标题'`回车在你的post文件夹下就新建了一个博文，打开编辑即可。然后使用`hexo g -d`部署到线上。

ps:每篇前面必加
>```
---
title: Hexo搭建个人博客笔记       ###文章题目
categories: Hexo                  ###自动创建分类
tags: GitHub hexo                 ###创建标签
---```

