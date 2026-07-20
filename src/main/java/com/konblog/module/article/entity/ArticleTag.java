package com.konblog.module.article.entity;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import java.io.Serializable;

@Data
@TableName("sg_article_tag")
public class ArticleTag implements Serializable {
    @TableId(type = IdType.AUTO) private Long id;
    private Long articleId, tagId;
}