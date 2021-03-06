USE SchoolBrowser
/* For security reasons the login is created disabled and with a random password. */
/****** Object:  Login [ReadWriteUser]    Script Date: 3/5/2015 8:25:13 PM ******/
CREATE LOGIN [ReadWriteUser] WITH PASSWORD='p@ssword'
GO

/****** Object:  User [ReadWriteUser]    Script Date: 3/5/2015 8:25:14 PM ******/
CREATE USER [ReadWriteUser] FOR LOGIN [ReadWriteUser] WITH DEFAULT_SCHEMA=[dbo]
GO
ALTER ROLE [db_datareader] ADD MEMBER [ReadWriteUser]
GO
ALTER ROLE [db_datawriter] ADD MEMBER [ReadWriteUser]
GO
/****** Object:  Table [dbo].[CourseForStudent]    Script Date: 3/5/2015 8:25:14 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[CourseForStudent](
	[Id] [int] IDENTITY(1,1) NOT NULL,
	[Student_Id] [int] NOT NULL,
	[Course_Id] [int] NOT NULL,
 CONSTRAINT [PK_CourseForStudent] PRIMARY KEY CLUSTERED 
(
	[Id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
/****** Object:  Table [dbo].[Courses]    Script Date: 3/5/2015 8:25:14 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Courses](
	[CourseId] [int] IDENTITY(1,1) NOT NULL,
	[CourseTitle] [nvarchar](100) NULL,
	[CourseCode] [nvarchar](10) NULL,
 CONSTRAINT [PK_Courses] PRIMARY KEY CLUSTERED 
(
	[CourseId] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
/****** Object:  Table [dbo].[Students]    Script Date: 3/5/2015 8:25:14 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Students](
	[StudentId] [int] IDENTITY(1,1) NOT NULL,
	[FirstName] [nvarchar](50) NULL,
	[LastName] [nvarchar](50) NULL,
 CONSTRAINT [PK_Students] PRIMARY KEY CLUSTERED 
(
	[StudentId] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
SET IDENTITY_INSERT [dbo].[CourseForStudent] ON 

INSERT [dbo].[CourseForStudent] ([Id], [Student_Id], [Course_Id]) VALUES (12, 1015, 12)
INSERT [dbo].[CourseForStudent] ([Id], [Student_Id], [Course_Id]) VALUES (13, 1016, 12)
INSERT [dbo].[CourseForStudent] ([Id], [Student_Id], [Course_Id]) VALUES (14, 1016, 10)
INSERT [dbo].[CourseForStudent] ([Id], [Student_Id], [Course_Id]) VALUES (15, 1017, 7)
INSERT [dbo].[CourseForStudent] ([Id], [Student_Id], [Course_Id]) VALUES (16, 1017, 9)
INSERT [dbo].[CourseForStudent] ([Id], [Student_Id], [Course_Id]) VALUES (18, 1017, 13)
INSERT [dbo].[CourseForStudent] ([Id], [Student_Id], [Course_Id]) VALUES (19, 1018, 9)
INSERT [dbo].[CourseForStudent] ([Id], [Student_Id], [Course_Id]) VALUES (21, 1013, 13)
INSERT [dbo].[CourseForStudent] ([Id], [Student_Id], [Course_Id]) VALUES (22, 1015, 7)
INSERT [dbo].[CourseForStudent] ([Id], [Student_Id], [Course_Id]) VALUES (23, 1015, 13)
INSERT [dbo].[CourseForStudent] ([Id], [Student_Id], [Course_Id]) VALUES (56, 1014, 10)
SET IDENTITY_INSERT [dbo].[CourseForStudent] OFF
SET IDENTITY_INSERT [dbo].[Courses] ON 

INSERT [dbo].[Courses] ([CourseId], [CourseTitle], [CourseCode]) VALUES (7, N'Programming Paradigms', N'1001')
INSERT [dbo].[Courses] ([CourseId], [CourseTitle], [CourseCode]) VALUES (8, N'Biology', N'2404')
INSERT [dbo].[Courses] ([CourseId], [CourseTitle], [CourseCode]) VALUES (9, N'Math', N'1404')
INSERT [dbo].[Courses] ([CourseId], [CourseTitle], [CourseCode]) VALUES (10, N'Environmental Studies', N'3333')
INSERT [dbo].[Courses] ([CourseId], [CourseTitle], [CourseCode]) VALUES (12, N'Java Applications', N'5001')
INSERT [dbo].[Courses] ([CourseId], [CourseTitle], [CourseCode]) VALUES (13, N'Distributed Systems', N'5201')
SET IDENTITY_INSERT [dbo].[Courses] OFF
SET IDENTITY_INSERT [dbo].[Students] ON 

INSERT [dbo].[Students] ([StudentId], [FirstName], [LastName]) VALUES (1013, N'Rachel ', N'Micks')
INSERT [dbo].[Students] ([StudentId], [FirstName], [LastName]) VALUES (1014, N'Sam', N'Myles')
INSERT [dbo].[Students] ([StudentId], [FirstName], [LastName]) VALUES (1015, N'January', N'Jones')
INSERT [dbo].[Students] ([StudentId], [FirstName], [LastName]) VALUES (1016, N'Don', N'Draper')
INSERT [dbo].[Students] ([StudentId], [FirstName], [LastName]) VALUES (1017, N'Michel', N'Myers')
INSERT [dbo].[Students] ([StudentId], [FirstName], [LastName]) VALUES (1018, N'Tom', N'Tompson')
SET IDENTITY_INSERT [dbo].[Students] OFF
ALTER TABLE [dbo].[CourseForStudent]  WITH CHECK ADD  CONSTRAINT [FK_CourseForStudent_Courses] FOREIGN KEY([Course_Id])
REFERENCES [dbo].[Courses] ([CourseId])
ON DELETE CASCADE
GO
ALTER TABLE [dbo].[CourseForStudent] CHECK CONSTRAINT [FK_CourseForStudent_Courses]
GO
ALTER TABLE [dbo].[CourseForStudent]  WITH CHECK ADD  CONSTRAINT [FK_CourseForStudent_Students] FOREIGN KEY([Student_Id])
REFERENCES [dbo].[Students] ([StudentId])
ON DELETE CASCADE
GO
ALTER TABLE [dbo].[CourseForStudent] CHECK CONSTRAINT [FK_CourseForStudent_Students]
GO
USE [master]
GO
ALTER DATABASE [SchoolBrowser] SET  READ_WRITE 
GO
