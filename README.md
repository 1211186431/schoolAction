# 校园场景行为分析系统

## 系统介绍
基于mmaction2行为识别框架，对训练数据集Kinetics400和行为识别算法 Swin Transformer针对“校园场景中学生的危险行为”进行改进。改进后对测试集的top1的准确率最高可以达到93.93%，top5的准确率可以达到100%。Web系统部分，使用 Java 语言结合 SpringBoot 框架、JS 语言结合 Vue 框架、python语言结合Flask框架，以及 MySQL 数据库等技术设计实现了一个 Web 系统，并且使用Redis缓存服务器完成行为识别检测任务消息队列。

## 代码
[前端](https://github.com/1211186431/schoolAction-Vue)
[后端](https://github.com/1211186431/schoolAction)
[行为识别](https://github.com/1211186431/schoolAction-Python)
