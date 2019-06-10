CREATE TABLE `users` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(30) NOT NULL,
  `password` varchar(30) NOT NULL,
  `email` varchar(50) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `username_UNIQUE` (`username`)
);

CREATE TABLE `repositories` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(50) NOT NULL,
  PRIMARY KEY (`id`)
);

CREATE TABLE `repositories_contributors` (
  `repository_id` int(11) NOT NULL,
  `contributor_id` int(11) NOT NULL,
  KEY `fk_rc_repositories_idx` (`repository_id`),
  KEY `fk_rc_users_idx` (`contributor_id`),
  CONSTRAINT `fk_rc_repositories` FOREIGN KEY (`repository_id`) REFERENCES `repositories` (`id`),
  CONSTRAINT `fk_rc_users` FOREIGN KEY (`contributor_id`) REFERENCES `users` (`id`)
);

CREATE TABLE `issues` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `title` varchar(255) NOT NULL,
  `issue_status` varchar(6) NOT NULL,
  `repository_id` int(11) NOT NULL,
  `assignee_id` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_issues_repositories_idx` (`repository_id`),
  KEY `fk_issues_users_idx` (`assignee_id`),
  CONSTRAINT `fk_issues_repositories` FOREIGN KEY (`repository_id`) REFERENCES `repositories` (`id`),
  CONSTRAINT `fk_issues_users` FOREIGN KEY (`assignee_id`) REFERENCES `users` (`id`)
);

CREATE TABLE `commits` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `message` varchar(255) NOT NULL,
  `issue_id` int(11) DEFAULT NULL,
  `repository_id` int(11) NOT NULL,
  `contributor_id` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_commits_issues_idx` (`issue_id`),
  KEY `fk_commits_repositories_idx` (`repository_id`),
  KEY `fk_commits_users_idx` (`contributor_id`),
  CONSTRAINT `fk_commits_issues` FOREIGN KEY (`issue_id`) REFERENCES `issues` (`id`),
  CONSTRAINT `fk_commits_repositories` FOREIGN KEY (`repository_id`) REFERENCES `repositories` (`id`),
  CONSTRAINT `fk_commits_users` FOREIGN KEY (`contributor_id`) REFERENCES `users` (`id`)
);

CREATE TABLE `files` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(100) NOT NULL,
  `size` decimal(10,2) NOT NULL,
  `parent_id` int(11) DEFAULT NULL,
  `commit_id` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_files_files_idx` (`parent_id`),
  KEY `fk_files_commits_idx` (`commit_id`),
  CONSTRAINT `fk_files_commits` FOREIGN KEY (`commit_id`) REFERENCES `commits` (`id`),
  CONSTRAINT `fk_files_files` FOREIGN KEY (`parent_id`) REFERENCES `files` (`id`)
);


