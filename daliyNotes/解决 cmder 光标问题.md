# 解决 cmder 光标问题

Jun 16, 2018

0 Comments

## 问题

由于 powershell 配置有些麻烦，所以最近在使用 cmder，然而在使用中有一个问题非常难受：
在cmder中，无论英文还是中文，输入的光标变宽或者多一个字符。

## 解决方法

进入 `%CMDER_ROOT%\vendor` 文件夹，编辑 `profile.ps1`，寻找下列信息(`Ctrl + F`)

```
Microsoft.PowerShell.Utility\Write-Host "`nλ " -NoNewLine -ForegroundColor "DarkGray"
```

将其中的 `λ` 改为 `#` 或其它字符即可。

------

如果使用的是 cmd，则编辑 `clink.lua`，寻找

`if env == nil then`
    `lambda = "λ"`
`else`
    `lambda = "("..env..") λ"`
`end`

将其中的 `λ` 改为 `#` 或其它字符即可。

