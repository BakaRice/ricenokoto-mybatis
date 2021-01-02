# ricenokoto-mybatis(リスのこと)
个人博客系统（SpringBoot+Mybatis）
博客地址：

### 所用技术
#### 1. 前端  
前端本来想采用vue.js外加前后的分离的方式进行编写，但经过思考后，
该项目仅为一个个人博客的小型项目，仅为我独立开发并使用，进行前后端分离实属没有必要，所以改用成为以下形式
- JS框架：JQuery
- CSS框架：Semantic UI官网
- Markdown编辑器：编辑器 Markdown
- 代码高亮：代码高亮 prism
- 动画效果：动画 animate.css
- 文章目录：目录生成 Tocbot
- 音乐盒：zplayer
- 照片墙：lightbox插件
#### 2. 后端
- 核心框架：SpringBoot 2.4.1
- 项目构建：jdk 11, Maven 3
- 持久层框架： Mybatis
- 模板框架：Thymeleaf
- 分页插件：PageHelper
- 加密：MD5加密
- 部署环境：Docker + HuaweiCloud Centos7

3. 数据库
- MySQL 8.0.17 / PostgreSQL(备选，准备进行学习)

### 功能需求

单用户的个人博客，没有用户权限管理的问题，仅需简单的区分出普通浏览用户和管理员用户，
根据普通用户和管理员用户来讲述功能需求。

#### 1. 普通用户
- 查看文章信息：文章列表/推荐文章/文章标题/文章内容/发布时间/访问量/评论
- 查看分类文章：分类列表/分类文章信息
- 查看时间轴：按照文章时间发布顺序查看文章
- 搜索文章：导航栏右侧搜索框根据关键字搜索
- 听音乐：上一曲/下一曲/音量控制/播放顺序控制/查看歌词等
- 留言：留言并回复
- 查看友链：查看并访问博主在友链页面添加的友链链接
- 查看相册信息：相册列表/照片名称/照片拍摄地点/时间/照片描述

#### 2. 管理员用户（博主）

- 拥有普通用户所有功能权限
- 登录：在主页路径下加入`/admin`，可进入登录页面，根据数据库的用户名和密码进行登录
- 文章管理：查询文章列表/新增文章/编辑文章/删除文章/搜索文章
- 分类管理：查询分类列表/新增分类/编辑分类/删除分类
- 友链管理：查询友链/新增友链/编辑友链/删除友链
- 相册管理：查询相册列表/新增照片/编辑照片/删除照片
- 消息管理：登录后恢复评论留言会显示博主的头像信息，并能显示删除消息按键，可以对消息进行删除

### 数据库设计

#### 1. 数据表
- 博客数据表：t_blog
- 分类数据表：t_type
- 用户数据表：t_user
- 评论数据表：t_comment
- 留言数据表：t_message
- 友链数据表：t_friend
- 相册数据表：t_picture
#### 2. 实体关系
   博客间实体关系：
   - 博客和分类是多对一的关系：一个博客对应一个分类，一个分类可以对应多个博客
   - 博客和用户是多对一的关系：一个博客对应一个用户，一个用户可以对应多个博客
   - 博客和评论是一对多的关系：一个博客可以对应多个评论，一个评论对应一个博客
   - 评论和回复是一对多的关系： 一个评论可以对应多个回复，一个回复对应一个评论
   
#### 3. 实体属性
+ 博客属性：`Blog(标题，内容，首图，标记，浏览次数，赞赏开启，版权开启，是否发布，创建时间，更新时间，评论开启，描述)`
+ 分类属性：`Type(名称）`
+ 用户属性：`User(昵称，用户名，密码，邮箱。类型，头像，创建时间，更新时间)`
+ 评论属性：`Comment(昵称，邮箱，头像，评论内容,创建时间，博客id，父评论id，管理员id)`
+ 留言属性：`Message(昵称，邮箱，头像，评论内容，创建时间，管理员id，父评论id)`
+ 友链属性：`Friend(网址、名称、创建时间、图片地址)`
+ 相册属性：`Picture(图片地址、图片描述、图片名称、拍摄时间地点)`


```sql
create table t_comment
(
    id                bigint auto_increment
        primary key,
    nickname          varchar(255) null,
    email             varchar(255) null,
    content           varchar(255) null,
    avatar            varchar(255) null,
    create_time       datetime     null,
    blog_id           bigint       null,
    parent_comment_id bigint       null,
    admin_comment     bit          not null
)
    charset = utf8;

create table t_friend
(
    id             bigint auto_increment
        primary key,
    blogaddress    varchar(255) not null,
    blogname       varchar(255) not null,
    create_time    datetime     null,
    pictureaddress varchar(255) not null
)
    charset = utf8;

create table t_message
(
    id                bigint auto_increment
        primary key,
    nickname          varchar(255) null,
    email             varchar(255) null,
    content           varchar(255) null,
    avatar            varchar(255) null,
    create_time       datetime     null,
    parent_message_id bigint       null,
    admin_message     bit          not null
)
    charset = utf8;

create table t_picture
(
    id                 bigint auto_increment
        primary key,
    pictureaddress     varchar(255) null,
    picturedescription varchar(255) null,
    picturename        varchar(255) null,
    picturetime        varchar(255) null
)
    charset = utf8;

create table t_type
(
    id   bigint auto_increment
        primary key,
    name varchar(255) not null
)
    charset = utf8;

create table t_user
(
    id          bigint auto_increment
        primary key,
    avatar      varchar(255) null,
    create_time datetime     null,
    email       varchar(255) null,
    nickname    varchar(255) null,
    password    varchar(255) null,
    type        int          null,
    update_time datetime     null,
    username    varchar(255) null
)
    charset = utf8;

create table t_blog
(
    id              bigint auto_increment
        primary key,
    appreciation    bit          not null,
    commentabled    bit          not null,
    content         longtext     null,
    create_time     datetime     null,
    description     varchar(255) null,
    first_picture   varchar(255) null,
    flag            varchar(255) null,
    published       bit          not null,
    recommend       bit          not null,
    share_statement bit          not null,
    title           varchar(255) null,
    update_time     datetime     null,
    views           int          null,
    type_id         bigint       null,
    user_id         bigint       null,
    comment_count   int(255)     null,
    constraint FK292449gwg5yf7ocdlmswv9w4j
        foreign key (type_id) references t_type (id),
    constraint FK8ky5rrsxh01nkhctmo7d48p82
        foreign key (user_id) references t_user (id)
)
    charset = utf8;


```