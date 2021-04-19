CREATE TABLE `subscribers` (
    `id` INTEGER NOT NULL,
    `subscriber_code` VARCHAR(128) NOT NULL,
    `first` VARCHAR(128) NOT NULL,
    `last` VARCHAR(128) NOT NULL,
    `email` VARCHAR(128) NOT NULL,
    PRIMARY KEY (`id`),
    UNIQUE KEY `ui_subscribers_subscriber_code` (subscriber_code)
)