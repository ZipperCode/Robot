# 关键词表
CREATE TABLE keyword{
    id INTEGER NOT NULL PRIMARY KEY,
    keyword VARCHAR(50) NOT NULL UNIQUE,
    nominal VARCHAR(10) NULL,
    word_weight TEXT,
    word_times INTEGER DEFAULT 0,
    ban CHAR(2) DEFAULT '1',
    create_time DATETIME DEFAULT CURRENT_TIMESTAMP ,
    update_time DATETIME DEFAULT CURRENT_TIMESTAMP
};
# 问题表
CREATE TABLE question{
    id INTEGER NO NULL PRIMARY KEY,
    question VARCHAR(255) NOT NULL,
    split TEXT,
    words_weight INTEGER NOT NULL DEFAULT 0,
    count_times INTEGER NOT NULL DEFAULT 1,
    create_time DATETIME DEFAULT CURRENT_TIMESTAMP ,
    update_time DATETIME DEFAULT CURRENT_TIMESTAMP
}
# 常用问题表
CREATE TABLE common{
    id INTEGER NOT NULL PRIMARY KEY ,
    question varchar(255) NOT NULL,
    answer varchar (255),
    count_times INTEGER NOT NULL DEFAULT 1,
    create_time DATETIME DEFAULT CURRENT_TIMESTAMP ,
    update_time DATETIME DEFAULT CURRENT_TIMESTAMP
}

# 未解答问题表
CREATE TABLE unanswered{
    id INTEGER NO NULL PRIMARY KEY,
    question VARCHAR(255) NOT NULL,
    split TEXT,
    words_weight INTEGER NOT NULL DEFAULT 0,
    count_times INTEGER NOT NULL DEFAULT 1,
    create_time DATETIME DEFAULT CURRENT_TIMESTAMP ,
    update_time DATETIME DEFAULT CURRENT_TIMESTAMP
}

