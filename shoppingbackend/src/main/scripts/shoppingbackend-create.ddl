
    create table Category (
        id  serial not null,
        is_active boolean,
        description varchar(255),
        image_url varchar(255),
        name varchar(255),
        primary key (id)
    );

    create table Product (
        id  serial not null,
        is_active boolean,
        brand varchar(255),
        category_id int4,
        code varchar(255),
        description varchar(255),
        name varchar(255),
        purchases int4 not null,
        quantity int4 not null,
        supplier_id int4,
        unit_price float8,
        views int4 not null,
        primary key (id)
    );
