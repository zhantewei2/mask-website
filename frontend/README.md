导航
---
[Inner Router 内嵌路由](readmes/routerSub.md)

案例文件
---
书写页面前，请先查看案例

地址：

[http://localhost:8080/home/sample-test1](http://localhost:8080/home/sample-test1)

文件地址:
```
src/views/sample/sample-test1-page/sample-test1-page.html
```


依赖安装
---
该项目依赖于ztwx-fire-ui

由于该项目暂时没有发布。手动拉取依赖.

- 请先拉取 依赖git https://github.com/zhantewei2/ztwx-fire-ui 

- 在依赖项目中执行 `npm link`

安装本项目
---

- 删除`package.json`中的`ztwx-fire-ui`依赖.
- 执行`yarn install`
- 在项目中执行`npm link ztwx-fire-ui`。
- `package.json `中 依赖加回去`{ztwx-fire-ui:"0.1.0"}`

项目文件命名
---
- 页面文件夹 `xxx-page`|`xxPage`
- 组件`xxx-component`|`xxComponent`
- 指令 `xxx-directive`|`xxDirective`

项目已启动的情况下，遵守该命名规范 。 

可获得神力，自动创建对应模板。

`webstorm`有时反应慢，下按`ctrl+alt+t`刷新，即可刷新出模板。

项目命令
---
开发环境启动

``
npm run runtime:dev
``

字体编辑启动
```
npm run webfont
```

目录
---
- `src/envs` 项目配置文件夹
- `src/views` 页面
- `src/commonViews` 通用页面

styles 目录
---
- `src/styles/_element.scss` element 重写变量文件
- `src/styles/var.scss` 项目变量文件
- `src/styles/ice.scss` ice框架变量重写文件

路由文件
---

- `src/router/index.ts` 主文件
- `src/router/views.router.ts` 功能页面路由，主文件
- `src/router/xxx.router.ts` xxx module对应路由文件 