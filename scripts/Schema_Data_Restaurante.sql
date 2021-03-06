USE [master]
GO

/****** Object:  Database [BDRestaurante]    Script Date: 7/5/2022 13:51:05 ******/
CREATE DATABASE [BDRestaurante]
GO
USE [BDRestaurante]
GO
/****** Object:  Table [dbo].[Cargo]    Script Date: 7/5/2022 13:51:05 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[Cargo](
	[CargoId] [nvarchar](30) NOT NULL,
	[Descripcion] [nvarchar](30) NOT NULL,
	[Habilitado] [char](1) NOT NULL,
PRIMARY KEY CLUSTERED 
(
	[CargoId] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[Carta]    Script Date: 7/5/2022 13:51:05 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[Carta](
	[CartaId] [int] NOT NULL,
	[Nombre] [nvarchar](100) NOT NULL,
	[Descripcion] [nvarchar](200) NOT NULL,
	[Precio] [decimal](10, 2) NOT NULL,
	[Descuento] [decimal](10, 2) NOT NULL,
	[CategoriaId] [int] NOT NULL,
	[Habilitado] [char](1) NOT NULL,
	[Estado] [nvarchar](100) NULL,
PRIMARY KEY CLUSTERED 
(
	[CartaId] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[Categoria]    Script Date: 7/5/2022 13:51:05 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[Categoria](
	[CategoriaId] [int] NOT NULL,
	[Descripcion] [nvarchar](50) NOT NULL,
	[Habilitado] [char](1) NOT NULL,
PRIMARY KEY CLUSTERED 
(
	[CategoriaId] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[Cliente]    Script Date: 7/5/2022 13:51:05 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Cliente](
	[ClienteId] [int] IDENTITY(1,1) NOT NULL,
	[ClienteName] [nvarchar](100) NOT NULL,
	[TipoDoc] [nvarchar](50) NULL,
	[NumDoc] [nvarchar](20) NULL,
	[Direccion] [nvarchar](200) NULL,
	[Contacto] [nvarchar](50) NULL,
PRIMARY KEY CLUSTERED 
(
	[ClienteId] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
/****** Object:  Table [dbo].[ComprobantePago]    Script Date: 7/5/2022 13:51:05 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[ComprobantePago](
	[NumComprobante] [int] IDENTITY(1,1) NOT NULL,
	[FechaEmision] [datetime] NOT NULL,
	[NumPedido] [int] NOT NULL,
	[SubTotal] [decimal](10, 2) NOT NULL,
	[IGV] [decimal](10, 2) NOT NULL,
	[Total] [decimal](10, 2) NOT NULL,
	[ClienteId] [int] NULL,
	[EmpleadoId] [int] NOT NULL,
	[TipoComID] [int] NOT NULL,
PRIMARY KEY CLUSTERED 
(
	[NumComprobante] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
/****** Object:  Table [dbo].[DetallePedido]    Script Date: 7/5/2022 13:51:05 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[DetallePedido](
	[NumPedido] [int] NOT NULL,
	[CartaId] [int] NOT NULL,
	[Cantidad] [int] NOT NULL,
	[Precio] [decimal](10, 2) NOT NULL,
	[Importe] [decimal](10, 2) NOT NULL,
	[EstadoDetalleId] [int] NOT NULL,
	[FechaHoraTermino] [datetime] NULL
) ON [PRIMARY]

GO
/****** Object:  Table [dbo].[Empleado]    Script Date: 7/5/2022 13:51:05 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[Empleado](
	[EmpleadoId] [int] IDENTITY(1,1) NOT NULL,
	[Nombre] [nvarchar](100) NOT NULL,
	[Apellido] [nvarchar](50) NOT NULL,
	[NumDoc] [nvarchar](20) NOT NULL,
	[CargoId] [nvarchar](30) NOT NULL,
	[Habilitado] [char](1) NOT NULL,
PRIMARY KEY CLUSTERED 
(
	[EmpleadoId] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[EstadoDetallePedido]    Script Date: 7/5/2022 13:51:05 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[EstadoDetallePedido](
	[EstadoIDetalleId] [int] NOT NULL,
	[Descripcion] [nvarchar](100) NOT NULL,
	[Habilitado] [char](1) NOT NULL,
PRIMARY KEY CLUSTERED 
(
	[EstadoIDetalleId] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[EstadoPedido]    Script Date: 7/5/2022 13:51:05 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[EstadoPedido](
	[EstadoId] [int] NOT NULL,
	[Descripcion] [nvarchar](30) NOT NULL,
	[Habilitado] [char](1) NOT NULL,
PRIMARY KEY CLUSTERED 
(
	[EstadoId] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[Mesa]    Script Date: 7/5/2022 13:51:05 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Mesa](
	[MesaId] [int] NOT NULL,
	[NumMesa] [int] NOT NULL,
PRIMARY KEY CLUSTERED 
(
	[MesaId] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
/****** Object:  Table [dbo].[MesaCamarero]    Script Date: 7/5/2022 13:51:05 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[MesaCamarero](
	[MesaId] [int] NOT NULL,
	[EmpleadoId] [int] NOT NULL,
	[FechaInicio] [smalldatetime] NOT NULL,
	[FechaFin] [smalldatetime] NOT NULL
) ON [PRIMARY]

GO
/****** Object:  Table [dbo].[NotaPedido]    Script Date: 7/5/2022 13:51:05 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[NotaPedido](
	[NumPedido] [int] IDENTITY(1,1) NOT NULL,
	[FechaHoraSolicitud] [datetime] NULL,
	[MontoPagar] [decimal](10, 2) NOT NULL,
	[EmpleadoId] [int] NULL,
	[NumMesa] [int] NULL,
	[EstadoId] [int] NULL,
	[Observacion] [nvarchar](100) NULL,
	[ClienteId] [int] NULL,
PRIMARY KEY CLUSTERED 
(
	[NumPedido] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
/****** Object:  Table [dbo].[TipoComprobante]    Script Date: 7/5/2022 13:51:05 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[TipoComprobante](
	[TipoComID] [int] NOT NULL,
	[Descripcion] [nvarchar](20) NOT NULL,
	[Habilitado] [char](1) NOT NULL,
PRIMARY KEY CLUSTERED 
(
	[TipoComID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[Usuario]    Script Date: 7/5/2022 13:51:05 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[Usuario](
	[UsuarioID] [int] IDENTITY(1,1) NOT NULL,
	[Usuario] [nvarchar](20) NOT NULL,
	[Password] [nvarchar](6) NOT NULL,
	[Rol] [nvarchar](50) NOT NULL,
	[Habilitado] [char](1) NOT NULL,
	[EmpleadoId] [int] NULL,
PRIMARY KEY CLUSTERED 
(
	[UsuarioID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
INSERT [dbo].[Cargo] ([CargoId], [Descripcion], [Habilitado]) VALUES (N'A001', N'Administrador', N'1')
INSERT [dbo].[Cargo] ([CargoId], [Descripcion], [Habilitado]) VALUES (N'AC01', N'Ayudante_cocina', N'1')
INSERT [dbo].[Cargo] ([CargoId], [Descripcion], [Habilitado]) VALUES (N'CO01', N'Cocinero', N'1')
INSERT [dbo].[Cargo] ([CargoId], [Descripcion], [Habilitado]) VALUES (N'G001', N'Gerente', N'1')
INSERT [dbo].[Cargo] ([CargoId], [Descripcion], [Habilitado]) VALUES (N'L001', N'Limpieza', N'1')
INSERT [dbo].[Cargo] ([CargoId], [Descripcion], [Habilitado]) VALUES (N'M001', N'Mozo', N'1')
INSERT [dbo].[Carta] ([CartaId], [Nombre], [Descripcion], [Precio], [Descuento], [CategoriaId], [Habilitado], [Estado]) VALUES (1, N'Pollo a la brasa + cuarto', N'1 Pollo a la Brasa + 1/4 papas fritas + ensaladas + cremas', CAST(45.00 AS Decimal(10, 2)), CAST(0.00 AS Decimal(10, 2)), 1, N'1', N'DISPONIBLE')
INSERT [dbo].[Carta] ([CartaId], [Nombre], [Descripcion], [Precio], [Descuento], [CategoriaId], [Habilitado], [Estado]) VALUES (2, N'Pollo a la Brasa', N'1 pollo a la brasa solo', CAST(25.00 AS Decimal(10, 2)), CAST(0.00 AS Decimal(10, 2)), 1, N'1', N'DISPONIBLE')
INSERT [dbo].[Carta] ([CartaId], [Nombre], [Descripcion], [Precio], [Descuento], [CategoriaId], [Habilitado], [Estado]) VALUES (3, N'Arroz con pollo', N'Arroz con pollo', CAST(25.00 AS Decimal(10, 2)), CAST(0.00 AS Decimal(10, 2)), 2, N'1', N'DISPONIBLE')
INSERT [dbo].[Carta] ([CartaId], [Nombre], [Descripcion], [Precio], [Descuento], [CategoriaId], [Habilitado], [Estado]) VALUES (4, N'Pollo a la brasa Personal', N'1/4 Pollo a la Brasa + 1/4 papas fritas + ensaladas + cremas', CAST(13.00 AS Decimal(10, 2)), CAST(0.00 AS Decimal(10, 2)), 2, N'1', N'DISPONIBLE')
INSERT [dbo].[Carta] ([CartaId], [Nombre], [Descripcion], [Precio], [Descuento], [CategoriaId], [Habilitado], [Estado]) VALUES (5, N'Promo 1 Pollo + gaseosa', N'1 Pollo a la Brasa + 1/4 papas fritas + ensaladas + cremas+ 1 litro gaseosa', CAST(40.00 AS Decimal(10, 2)), CAST(15.00 AS Decimal(10, 2)), 7, N'1', N'DISPONIBLE')
INSERT [dbo].[Carta] ([CartaId], [Nombre], [Descripcion], [Precio], [Descuento], [CategoriaId], [Habilitado], [Estado]) VALUES (6, N'Lomo Saltado de carne', N'Lomo Saltado de carne', CAST(10.00 AS Decimal(10, 2)), CAST(0.00 AS Decimal(10, 2)), 2, N'1', N'DISPONIBLE')
INSERT [dbo].[Carta] ([CartaId], [Nombre], [Descripcion], [Precio], [Descuento], [CategoriaId], [Habilitado], [Estado]) VALUES (7, N'Pollo a la Plancha', N'Pollo a la Plancha', CAST(10.00 AS Decimal(10, 2)), CAST(0.00 AS Decimal(10, 2)), 2, N'1', N'DISPONIBLE')
INSERT [dbo].[Carta] ([CartaId], [Nombre], [Descripcion], [Precio], [Descuento], [CategoriaId], [Habilitado], [Estado]) VALUES (8, N'Pollo a la Parrilla', N'Pollo a la Parrilla', CAST(15.00 AS Decimal(10, 2)), CAST(0.00 AS Decimal(10, 2)), 2, N'1', N'DISPONIBLE')
INSERT [dbo].[Carta] ([CartaId], [Nombre], [Descripcion], [Precio], [Descuento], [CategoriaId], [Habilitado], [Estado]) VALUES (9, N'porcion de ensalada', N'Una porcion de ensalada', CAST(3.00 AS Decimal(10, 2)), CAST(0.00 AS Decimal(10, 2)), 3, N'1', N'DISPONIBLE')
INSERT [dbo].[Carta] ([CartaId], [Nombre], [Descripcion], [Precio], [Descuento], [CategoriaId], [Habilitado], [Estado]) VALUES (10, N'porcion de ensalada mixta', N'Una porcion de ensalada mixta', CAST(3.50 AS Decimal(10, 2)), CAST(0.00 AS Decimal(10, 2)), 3, N'1', N'DISPONIBLE')
INSERT [dbo].[Carta] ([CartaId], [Nombre], [Descripcion], [Precio], [Descuento], [CategoriaId], [Habilitado], [Estado]) VALUES (11, N'Porcion de helados de 3 sabores', N'Una Porcion de helados de 3 sabores', CAST(6.00 AS Decimal(10, 2)), CAST(0.00 AS Decimal(10, 2)), 4, N'1', N'DISPONIBLE')
INSERT [dbo].[Carta] ([CartaId], [Nombre], [Descripcion], [Precio], [Descuento], [CategoriaId], [Habilitado], [Estado]) VALUES (12, N'Porcion de helados de 2 sabores', N'Una Porcion de helados de 2 sabores', CAST(4.00 AS Decimal(10, 2)), CAST(0.00 AS Decimal(10, 2)), 4, N'1', N'DISPONIBLE')
INSERT [dbo].[Carta] ([CartaId], [Nombre], [Descripcion], [Precio], [Descuento], [CategoriaId], [Habilitado], [Estado]) VALUES (13, N'Porcion de torta selva negra', N'Una Porcion de torta selva negra', CAST(3.50 AS Decimal(10, 2)), CAST(0.00 AS Decimal(10, 2)), 4, N'1', N'DISPONIBLE')
INSERT [dbo].[Carta] ([CartaId], [Nombre], [Descripcion], [Precio], [Descuento], [CategoriaId], [Habilitado], [Estado]) VALUES (14, N'Porcion de torta de chocolate', N'Una Porcion de torta de chocolate', CAST(3.50 AS Decimal(10, 2)), CAST(0.00 AS Decimal(10, 2)), 4, N'1', N'DISPONIBLE')
INSERT [dbo].[Carta] ([CartaId], [Nombre], [Descripcion], [Precio], [Descuento], [CategoriaId], [Habilitado], [Estado]) VALUES (15, N'Porcion de torta de 3 leches', N'Una Porcion de torta de 3 leches', CAST(4.50 AS Decimal(10, 2)), CAST(0.00 AS Decimal(10, 2)), 4, N'1', N'DISPONIBLE')
INSERT [dbo].[Carta] ([CartaId], [Nombre], [Descripcion], [Precio], [Descuento], [CategoriaId], [Habilitado], [Estado]) VALUES (16, N'litro de gaseosa inka kola', N'1 litro de gaseosa inka kola', CAST(5.00 AS Decimal(10, 2)), CAST(0.00 AS Decimal(10, 2)), 5, N'1', N'DISPONIBLE')
INSERT [dbo].[Carta] ([CartaId], [Nombre], [Descripcion], [Precio], [Descuento], [CategoriaId], [Habilitado], [Estado]) VALUES (17, N'litro de gaseosa coca cola', N'1 litro de gaseosa coca cola', CAST(5.00 AS Decimal(10, 2)), CAST(0.00 AS Decimal(10, 2)), 5, N'1', N'DISPONIBLE')
INSERT [dbo].[Carta] ([CartaId], [Nombre], [Descripcion], [Precio], [Descuento], [CategoriaId], [Habilitado], [Estado]) VALUES (18, N'gaseosa personal inka kola', N'1 gaseosa personal inka kola', CAST(2.00 AS Decimal(10, 2)), CAST(0.00 AS Decimal(10, 2)), 5, N'1', N'DISPONIBLE')
INSERT [dbo].[Carta] ([CartaId], [Nombre], [Descripcion], [Precio], [Descuento], [CategoriaId], [Habilitado], [Estado]) VALUES (19, N'gaseosa personal coca cola', N'1 gaseosa personal coca cola', CAST(2.00 AS Decimal(10, 2)), CAST(0.00 AS Decimal(10, 2)), 5, N'1', N'DISPONIBLE')
INSERT [dbo].[Carta] ([CartaId], [Nombre], [Descripcion], [Precio], [Descuento], [CategoriaId], [Habilitado], [Estado]) VALUES (20, N'botella de vino santiago queirolo', N'1 botella de vino santiago queirolo', CAST(25.00 AS Decimal(10, 2)), CAST(0.00 AS Decimal(10, 2)), 5, N'1', N'DISPONIBLE')
INSERT [dbo].[Carta] ([CartaId], [Nombre], [Descripcion], [Precio], [Descuento], [CategoriaId], [Habilitado], [Estado]) VALUES (21, N'jarra de cerveza', N'1 jarra de cerveza', CAST(15.00 AS Decimal(10, 2)), CAST(0.00 AS Decimal(10, 2)), 5, N'1', N'DISPONIBLE')
INSERT [dbo].[Carta] ([CartaId], [Nombre], [Descripcion], [Precio], [Descuento], [CategoriaId], [Habilitado], [Estado]) VALUES (22, N'agua mineral', N'1 agua mineral', CAST(1.50 AS Decimal(10, 2)), CAST(0.00 AS Decimal(10, 2)), 5, N'1', N'DISPONIBLE')
INSERT [dbo].[Carta] ([CartaId], [Nombre], [Descripcion], [Precio], [Descuento], [CategoriaId], [Habilitado], [Estado]) VALUES (23, N'taza de cafe', N'taza de cafe', CAST(2.00 AS Decimal(10, 2)), CAST(0.00 AS Decimal(10, 2)), 6, N'1', N'DISPONIBLE')
INSERT [dbo].[Carta] ([CartaId], [Nombre], [Descripcion], [Precio], [Descuento], [CategoriaId], [Habilitado], [Estado]) VALUES (24, N'taza de te', N'taza de te', CAST(2.00 AS Decimal(10, 2)), CAST(0.00 AS Decimal(10, 2)), 6, N'1', N'DISPONIBLE')
INSERT [dbo].[Carta] ([CartaId], [Nombre], [Descripcion], [Precio], [Descuento], [CategoriaId], [Habilitado], [Estado]) VALUES (25, N'taza de manzanilla', N'taza de manzanilla', CAST(2.00 AS Decimal(10, 2)), CAST(0.00 AS Decimal(10, 2)), 6, N'1', N'DISPONIBLE')
INSERT [dbo].[Carta] ([CartaId], [Nombre], [Descripcion], [Precio], [Descuento], [CategoriaId], [Habilitado], [Estado]) VALUES (26, N'pollo brosters', N'Porcion de pollo brosters', CAST(6.00 AS Decimal(10, 2)), CAST(0.00 AS Decimal(10, 2)), 8, N'1', N'DISPONIBLE')
INSERT [dbo].[Carta] ([CartaId], [Nombre], [Descripcion], [Precio], [Descuento], [CategoriaId], [Habilitado], [Estado]) VALUES (28, N'Una Porcion de torta de chocolate fresa', N'Una Porcion de torta de chocolate fresa', CAST(12.00 AS Decimal(10, 2)), CAST(1.00 AS Decimal(10, 2)), 4, N'1', N'DISPONIBLE')
INSERT [dbo].[Carta] ([CartaId], [Nombre], [Descripcion], [Precio], [Descuento], [CategoriaId], [Habilitado], [Estado]) VALUES (30, N'Una Porcion de torta de chocolate lucuma', N'Una Porcion de torta de chocolate lucuma', CAST(5.20 AS Decimal(10, 2)), CAST(0.00 AS Decimal(10, 2)), 4, N'1', N'DISPONIBLE')
INSERT [dbo].[Carta] ([CartaId], [Nombre], [Descripcion], [Precio], [Descuento], [CategoriaId], [Habilitado], [Estado]) VALUES (32, N'plato prueba', N'Una Porcion de helados de 3 sabores', CAST(8.00 AS Decimal(10, 2)), CAST(0.00 AS Decimal(10, 2)), 1, N'0', N'NO DISPONIBLE')
INSERT [dbo].[Categoria] ([CategoriaId], [Descripcion], [Habilitado]) VALUES (1, N'POLLOS A LA BRASA', N'1')
INSERT [dbo].[Categoria] ([CategoriaId], [Descripcion], [Habilitado]) VALUES (2, N'PLATOS A LA CARTA', N'1')
INSERT [dbo].[Categoria] ([CategoriaId], [Descripcion], [Habilitado]) VALUES (3, N'ENSALADAS', N'1')
INSERT [dbo].[Categoria] ([CategoriaId], [Descripcion], [Habilitado]) VALUES (4, N'POSTRES', N'1')
INSERT [dbo].[Categoria] ([CategoriaId], [Descripcion], [Habilitado]) VALUES (5, N'BEBIDAS', N'1')
INSERT [dbo].[Categoria] ([CategoriaId], [Descripcion], [Habilitado]) VALUES (6, N'INFUSIONES', N'1')
INSERT [dbo].[Categoria] ([CategoriaId], [Descripcion], [Habilitado]) VALUES (7, N'PROMOCION', N'1')
INSERT [dbo].[Categoria] ([CategoriaId], [Descripcion], [Habilitado]) VALUES (8, N'BROSTERS', N'1')
SET IDENTITY_INSERT [dbo].[Cliente] ON 

INSERT [dbo].[Cliente] ([ClienteId], [ClienteName], [TipoDoc], [NumDoc], [Direccion], [Contacto]) VALUES (1, N'Generico', N'DNI', N'00000000', N'Sin Direccion', N'00000000')
INSERT [dbo].[Cliente] ([ClienteId], [ClienteName], [TipoDoc], [NumDoc], [Direccion], [Contacto]) VALUES (2, N'Francisco Castro ', N'DNI', N'45454545', N'LIMA', N'985874589')
SET IDENTITY_INSERT [dbo].[Cliente] OFF
SET IDENTITY_INSERT [dbo].[ComprobantePago] ON 

INSERT [dbo].[ComprobantePago] ([NumComprobante], [FechaEmision], [NumPedido], [SubTotal], [IGV], [Total], [ClienteId], [EmpleadoId], [TipoComID]) VALUES (1, CAST(0x0000AE81012E495B AS DateTime), 1, CAST(84.46 AS Decimal(10, 2)), CAST(18.54 AS Decimal(10, 2)), CAST(103.00 AS Decimal(10, 2)), 1, 2, 1)
INSERT [dbo].[ComprobantePago] ([NumComprobante], [FechaEmision], [NumPedido], [SubTotal], [IGV], [Total], [ClienteId], [EmpleadoId], [TipoComID]) VALUES (2, CAST(0x0000AE8101327AA2 AS DateTime), 2, CAST(45.10 AS Decimal(10, 2)), CAST(9.90 AS Decimal(10, 2)), CAST(55.00 AS Decimal(10, 2)), 1, 4, 1)
INSERT [dbo].[ComprobantePago] ([NumComprobante], [FechaEmision], [NumPedido], [SubTotal], [IGV], [Total], [ClienteId], [EmpleadoId], [TipoComID]) VALUES (4, CAST(0x0000AE82014533B9 AS DateTime), 6, CAST(206.64 AS Decimal(10, 2)), CAST(45.36 AS Decimal(10, 2)), CAST(252.00 AS Decimal(10, 2)), 2, 4, 2)
INSERT [dbo].[ComprobantePago] ([NumComprobante], [FechaEmision], [NumPedido], [SubTotal], [IGV], [Total], [ClienteId], [EmpleadoId], [TipoComID]) VALUES (5, CAST(0x0000AE850140F909 AS DateTime), 3, CAST(77.90 AS Decimal(10, 2)), CAST(17.10 AS Decimal(10, 2)), CAST(95.00 AS Decimal(10, 2)), 1, 2, 1)
INSERT [dbo].[ComprobantePago] ([NumComprobante], [FechaEmision], [NumPedido], [SubTotal], [IGV], [Total], [ClienteId], [EmpleadoId], [TipoComID]) VALUES (6, CAST(0x0000AE8501593226 AS DateTime), 4, CAST(132.00 AS Decimal(10, 2)), CAST(29.00 AS Decimal(10, 2)), CAST(161.00 AS Decimal(10, 2)), 1, 4, 2)
INSERT [dbo].[ComprobantePago] ([NumComprobante], [FechaEmision], [NumPedido], [SubTotal], [IGV], [Total], [ClienteId], [EmpleadoId], [TipoComID]) VALUES (7, CAST(0x0000AE85015F65D6 AS DateTime), 10, CAST(117.00 AS Decimal(10, 2)), CAST(26.00 AS Decimal(10, 2)), CAST(143.00 AS Decimal(10, 2)), 2, 4, 2)
INSERT [dbo].[ComprobantePago] ([NumComprobante], [FechaEmision], [NumPedido], [SubTotal], [IGV], [Total], [ClienteId], [EmpleadoId], [TipoComID]) VALUES (8, CAST(0x0000AE8701235DEC AS DateTime), 5, CAST(189.00 AS Decimal(10, 2)), CAST(41.00 AS Decimal(10, 2)), CAST(230.00 AS Decimal(10, 2)), 2, 3, 2)
INSERT [dbo].[ComprobantePago] ([NumComprobante], [FechaEmision], [NumPedido], [SubTotal], [IGV], [Total], [ClienteId], [EmpleadoId], [TipoComID]) VALUES (9, CAST(0x0000AE88009D767B AS DateTime), 8, CAST(62.00 AS Decimal(10, 2)), CAST(14.00 AS Decimal(10, 2)), CAST(76.00 AS Decimal(10, 2)), 1, 3, 2)
INSERT [dbo].[ComprobantePago] ([NumComprobante], [FechaEmision], [NumPedido], [SubTotal], [IGV], [Total], [ClienteId], [EmpleadoId], [TipoComID]) VALUES (10, CAST(0x0000AE8800A68BB0 AS DateTime), 7, CAST(167.00 AS Decimal(10, 2)), CAST(37.00 AS Decimal(10, 2)), CAST(204.00 AS Decimal(10, 2)), 2, 3, 2)
INSERT [dbo].[ComprobantePago] ([NumComprobante], [FechaEmision], [NumPedido], [SubTotal], [IGV], [Total], [ClienteId], [EmpleadoId], [TipoComID]) VALUES (11, CAST(0x0000AE8801330FE5 AS DateTime), 9, CAST(104.00 AS Decimal(10, 2)), CAST(23.00 AS Decimal(10, 2)), CAST(127.00 AS Decimal(10, 2)), 2, 2, 1)
INSERT [dbo].[ComprobantePago] ([NumComprobante], [FechaEmision], [NumPedido], [SubTotal], [IGV], [Total], [ClienteId], [EmpleadoId], [TipoComID]) VALUES (12, CAST(0x0000AE8B014EEC50 AS DateTime), 11, CAST(17.00 AS Decimal(10, 2)), CAST(4.00 AS Decimal(10, 2)), CAST(21.00 AS Decimal(10, 2)), 1, 4, 2)
INSERT [dbo].[ComprobantePago] ([NumComprobante], [FechaEmision], [NumPedido], [SubTotal], [IGV], [Total], [ClienteId], [EmpleadoId], [TipoComID]) VALUES (13, CAST(0x0000AE8E00AD9E76 AS DateTime), 12, CAST(295.00 AS Decimal(10, 2)), CAST(65.00 AS Decimal(10, 2)), CAST(360.00 AS Decimal(10, 2)), 1, 3, 1)
INSERT [dbo].[ComprobantePago] ([NumComprobante], [FechaEmision], [NumPedido], [SubTotal], [IGV], [Total], [ClienteId], [EmpleadoId], [TipoComID]) VALUES (14, CAST(0x0000AE8E00E2AA63 AS DateTime), 13, CAST(34.00 AS Decimal(10, 2)), CAST(8.00 AS Decimal(10, 2)), CAST(42.00 AS Decimal(10, 2)), 2, 3, 1)
SET IDENTITY_INSERT [dbo].[ComprobantePago] OFF
INSERT [dbo].[DetallePedido] ([NumPedido], [CartaId], [Cantidad], [Precio], [Importe], [EstadoDetalleId], [FechaHoraTermino]) VALUES (1, 1, 2, CAST(45.00 AS Decimal(10, 2)), CAST(90.00 AS Decimal(10, 2)), 3, CAST(0x0000AE80015F4326 AS DateTime))
INSERT [dbo].[DetallePedido] ([NumPedido], [CartaId], [Cantidad], [Precio], [Importe], [EstadoDetalleId], [FechaHoraTermino]) VALUES (1, 16, 2, CAST(5.00 AS Decimal(10, 2)), CAST(10.00 AS Decimal(10, 2)), 1, CAST(0x0000AE80009FA428 AS DateTime))
INSERT [dbo].[DetallePedido] ([NumPedido], [CartaId], [Cantidad], [Precio], [Importe], [EstadoDetalleId], [FechaHoraTermino]) VALUES (1, 9, 1, CAST(3.00 AS Decimal(10, 2)), CAST(3.00 AS Decimal(10, 2)), 3, CAST(0x0000AE81012DDABE AS DateTime))
INSERT [dbo].[DetallePedido] ([NumPedido], [CartaId], [Cantidad], [Precio], [Importe], [EstadoDetalleId], [FechaHoraTermino]) VALUES (2, 1, 1, CAST(45.00 AS Decimal(10, 2)), CAST(45.00 AS Decimal(10, 2)), 3, CAST(0x0000AE8101326D3A AS DateTime))
INSERT [dbo].[DetallePedido] ([NumPedido], [CartaId], [Cantidad], [Precio], [Importe], [EstadoDetalleId], [FechaHoraTermino]) VALUES (2, 16, 2, CAST(5.00 AS Decimal(10, 2)), CAST(10.00 AS Decimal(10, 2)), 1, NULL)
INSERT [dbo].[DetallePedido] ([NumPedido], [CartaId], [Cantidad], [Precio], [Importe], [EstadoDetalleId], [FechaHoraTermino]) VALUES (3, 26, 5, CAST(6.00 AS Decimal(10, 2)), CAST(30.00 AS Decimal(10, 2)), 3, CAST(0x0000AE81013E9D0A AS DateTime))
INSERT [dbo].[DetallePedido] ([NumPedido], [CartaId], [Cantidad], [Precio], [Importe], [EstadoDetalleId], [FechaHoraTermino]) VALUES (3, 6, 5, CAST(10.00 AS Decimal(10, 2)), CAST(50.00 AS Decimal(10, 2)), 3, CAST(0x0000AE8501425837 AS DateTime))
INSERT [dbo].[DetallePedido] ([NumPedido], [CartaId], [Cantidad], [Precio], [Importe], [EstadoDetalleId], [FechaHoraTermino]) VALUES (3, 9, 5, CAST(3.00 AS Decimal(10, 2)), CAST(15.00 AS Decimal(10, 2)), 3, CAST(0x0000AE8501426088 AS DateTime))
INSERT [dbo].[DetallePedido] ([NumPedido], [CartaId], [Cantidad], [Precio], [Importe], [EstadoDetalleId], [FechaHoraTermino]) VALUES (4, 3, 6, CAST(25.00 AS Decimal(10, 2)), CAST(150.00 AS Decimal(10, 2)), 3, CAST(0x0000AE850158C0CE AS DateTime))
INSERT [dbo].[DetallePedido] ([NumPedido], [CartaId], [Cantidad], [Precio], [Importe], [EstadoDetalleId], [FechaHoraTermino]) VALUES (5, 3, 5, CAST(25.00 AS Decimal(10, 2)), CAST(125.00 AS Decimal(10, 2)), 3, CAST(0x0000AE8701233751 AS DateTime))
INSERT [dbo].[DetallePedido] ([NumPedido], [CartaId], [Cantidad], [Precio], [Importe], [EstadoDetalleId], [FechaHoraTermino]) VALUES (5, 23, 10, CAST(2.00 AS Decimal(10, 2)), CAST(20.00 AS Decimal(10, 2)), 3, CAST(0x0000AE8701234198 AS DateTime))
INSERT [dbo].[DetallePedido] ([NumPedido], [CartaId], [Cantidad], [Precio], [Importe], [EstadoDetalleId], [FechaHoraTermino]) VALUES (6, 3, 10, CAST(25.00 AS Decimal(10, 2)), CAST(250.00 AS Decimal(10, 2)), 3, CAST(0x0000AE820144BB6B AS DateTime))
INSERT [dbo].[DetallePedido] ([NumPedido], [CartaId], [Cantidad], [Precio], [Importe], [EstadoDetalleId], [FechaHoraTermino]) VALUES (6, 23, 1, CAST(2.00 AS Decimal(10, 2)), CAST(2.00 AS Decimal(10, 2)), 3, CAST(0x0000AE88009DE519 AS DateTime))
INSERT [dbo].[DetallePedido] ([NumPedido], [CartaId], [Cantidad], [Precio], [Importe], [EstadoDetalleId], [FechaHoraTermino]) VALUES (7, 1, 4, CAST(45.00 AS Decimal(10, 2)), CAST(180.00 AS Decimal(10, 2)), 3, CAST(0x0000AE8800A66DD6 AS DateTime))
INSERT [dbo].[DetallePedido] ([NumPedido], [CartaId], [Cantidad], [Precio], [Importe], [EstadoDetalleId], [FechaHoraTermino]) VALUES (8, 11, 8, CAST(6.00 AS Decimal(10, 2)), CAST(48.00 AS Decimal(10, 2)), 1, NULL)
INSERT [dbo].[DetallePedido] ([NumPedido], [CartaId], [Cantidad], [Precio], [Importe], [EstadoDetalleId], [FechaHoraTermino]) VALUES (8, 23, 2, CAST(2.00 AS Decimal(10, 2)), CAST(4.00 AS Decimal(10, 2)), 3, CAST(0x0000AE88009DF103 AS DateTime))
INSERT [dbo].[DetallePedido] ([NumPedido], [CartaId], [Cantidad], [Precio], [Importe], [EstadoDetalleId], [FechaHoraTermino]) VALUES (9, 5, 5, CAST(25.00 AS Decimal(10, 2)), CAST(125.00 AS Decimal(10, 2)), 3, CAST(0x0000AE880132E601 AS DateTime))
INSERT [dbo].[DetallePedido] ([NumPedido], [CartaId], [Cantidad], [Precio], [Importe], [EstadoDetalleId], [FechaHoraTermino]) VALUES (10, 7, 7, CAST(10.00 AS Decimal(10, 2)), CAST(70.00 AS Decimal(10, 2)), 3, CAST(0x0000AE85015F0B54 AS DateTime))
INSERT [dbo].[DetallePedido] ([NumPedido], [CartaId], [Cantidad], [Precio], [Importe], [EstadoDetalleId], [FechaHoraTermino]) VALUES (11, 10, 7, CAST(3.00 AS Decimal(10, 2)), CAST(21.00 AS Decimal(10, 2)), 3, CAST(0x0000AE8B014ED091 AS DateTime))
INSERT [dbo].[DetallePedido] ([NumPedido], [CartaId], [Cantidad], [Precio], [Importe], [EstadoDetalleId], [FechaHoraTermino]) VALUES (12, 1, 8, CAST(45.00 AS Decimal(10, 2)), CAST(360.00 AS Decimal(10, 2)), 3, CAST(0x0000AE8E00AD74A3 AS DateTime))
INSERT [dbo].[DetallePedido] ([NumPedido], [CartaId], [Cantidad], [Precio], [Importe], [EstadoDetalleId], [FechaHoraTermino]) VALUES (13, 9, 7, CAST(3.00 AS Decimal(10, 2)), CAST(21.00 AS Decimal(10, 2)), 3, CAST(0x0000AE8E00E279FC AS DateTime))
INSERT [dbo].[DetallePedido] ([NumPedido], [CartaId], [Cantidad], [Precio], [Importe], [EstadoDetalleId], [FechaHoraTermino]) VALUES (16, 3, 5, CAST(25.00 AS Decimal(10, 2)), CAST(125.00 AS Decimal(10, 2)), 1, NULL)
INSERT [dbo].[DetallePedido] ([NumPedido], [CartaId], [Cantidad], [Precio], [Importe], [EstadoDetalleId], [FechaHoraTermino]) VALUES (17, 28, 8, CAST(11.00 AS Decimal(10, 2)), CAST(88.00 AS Decimal(10, 2)), 1, NULL)
INSERT [dbo].[DetallePedido] ([NumPedido], [CartaId], [Cantidad], [Precio], [Importe], [EstadoDetalleId], [FechaHoraTermino]) VALUES (18, 6, 4, CAST(10.00 AS Decimal(10, 2)), CAST(40.00 AS Decimal(10, 2)), 1, NULL)
INSERT [dbo].[DetallePedido] ([NumPedido], [CartaId], [Cantidad], [Precio], [Importe], [EstadoDetalleId], [FechaHoraTermino]) VALUES (4, 28, 1, CAST(11.00 AS Decimal(10, 2)), CAST(11.00 AS Decimal(10, 2)), 1, NULL)
INSERT [dbo].[DetallePedido] ([NumPedido], [CartaId], [Cantidad], [Precio], [Importe], [EstadoDetalleId], [FechaHoraTermino]) VALUES (5, 2, 1, CAST(25.00 AS Decimal(10, 2)), CAST(25.00 AS Decimal(10, 2)), 3, CAST(0x0000AE870107E67F AS DateTime))
INSERT [dbo].[DetallePedido] ([NumPedido], [CartaId], [Cantidad], [Precio], [Importe], [EstadoDetalleId], [FechaHoraTermino]) VALUES (15, 11, 8, CAST(6.00 AS Decimal(10, 2)), CAST(48.00 AS Decimal(10, 2)), 1, NULL)
INSERT [dbo].[DetallePedido] ([NumPedido], [CartaId], [Cantidad], [Precio], [Importe], [EstadoDetalleId], [FechaHoraTermino]) VALUES (18, 16, 2, CAST(5.00 AS Decimal(10, 2)), CAST(10.00 AS Decimal(10, 2)), 1, NULL)
INSERT [dbo].[DetallePedido] ([NumPedido], [CartaId], [Cantidad], [Precio], [Importe], [EstadoDetalleId], [FechaHoraTermino]) VALUES (5, 26, 10, CAST(6.00 AS Decimal(10, 2)), CAST(60.00 AS Decimal(10, 2)), 3, CAST(0x0000AE8701232BC0 AS DateTime))
INSERT [dbo].[DetallePedido] ([NumPedido], [CartaId], [Cantidad], [Precio], [Importe], [EstadoDetalleId], [FechaHoraTermino]) VALUES (8, 9, 8, CAST(3.00 AS Decimal(10, 2)), CAST(24.00 AS Decimal(10, 2)), 3, CAST(0x0000AE88009DF97F AS DateTime))
INSERT [dbo].[DetallePedido] ([NumPedido], [CartaId], [Cantidad], [Precio], [Importe], [EstadoDetalleId], [FechaHoraTermino]) VALUES (16, 11, 4, CAST(6.00 AS Decimal(10, 2)), CAST(24.00 AS Decimal(10, 2)), 1, NULL)
INSERT [dbo].[DetallePedido] ([NumPedido], [CartaId], [Cantidad], [Precio], [Importe], [EstadoDetalleId], [FechaHoraTermino]) VALUES (7, 9, 8, CAST(3.00 AS Decimal(10, 2)), CAST(24.00 AS Decimal(10, 2)), 3, CAST(0x0000AE8800A66648 AS DateTime))
INSERT [dbo].[DetallePedido] ([NumPedido], [CartaId], [Cantidad], [Precio], [Importe], [EstadoDetalleId], [FechaHoraTermino]) VALUES (13, 10, 7, CAST(3.00 AS Decimal(10, 2)), CAST(21.00 AS Decimal(10, 2)), 3, CAST(0x0000AE8E00E282F5 AS DateTime))
INSERT [dbo].[DetallePedido] ([NumPedido], [CartaId], [Cantidad], [Precio], [Importe], [EstadoDetalleId], [FechaHoraTermino]) VALUES (17, 23, 1, CAST(2.00 AS Decimal(10, 2)), CAST(2.00 AS Decimal(10, 2)), 1, NULL)
INSERT [dbo].[DetallePedido] ([NumPedido], [CartaId], [Cantidad], [Precio], [Importe], [EstadoDetalleId], [FechaHoraTermino]) VALUES (9, 24, 1, CAST(2.00 AS Decimal(10, 2)), CAST(2.00 AS Decimal(10, 2)), 3, CAST(0x0000AE880132F432 AS DateTime))
INSERT [dbo].[DetallePedido] ([NumPedido], [CartaId], [Cantidad], [Precio], [Importe], [EstadoDetalleId], [FechaHoraTermino]) VALUES (10, 4, 4, CAST(13.00 AS Decimal(10, 2)), CAST(52.00 AS Decimal(10, 2)), 3, CAST(0x0000AE85015F1DA5 AS DateTime))
INSERT [dbo].[DetallePedido] ([NumPedido], [CartaId], [Cantidad], [Precio], [Importe], [EstadoDetalleId], [FechaHoraTermino]) VALUES (14, 1, 9, CAST(45.00 AS Decimal(10, 2)), CAST(405.00 AS Decimal(10, 2)), 1, NULL)
INSERT [dbo].[DetallePedido] ([NumPedido], [CartaId], [Cantidad], [Precio], [Importe], [EstadoDetalleId], [FechaHoraTermino]) VALUES (10, 9, 7, CAST(3.00 AS Decimal(10, 2)), CAST(21.00 AS Decimal(10, 2)), 3, CAST(0x0000AE85015ED2DF AS DateTime))
INSERT [dbo].[DetallePedido] ([NumPedido], [CartaId], [Cantidad], [Precio], [Importe], [EstadoDetalleId], [FechaHoraTermino]) VALUES (15, 5, 4, CAST(25.00 AS Decimal(10, 2)), CAST(100.00 AS Decimal(10, 2)), 1, NULL)
SET IDENTITY_INSERT [dbo].[Empleado] ON 

INSERT [dbo].[Empleado] ([EmpleadoId], [Nombre], [Apellido], [NumDoc], [CargoId], [Habilitado]) VALUES (1, N'Karla', N'Ccallo Choque', N'43078337', N'G001', N'1')
INSERT [dbo].[Empleado] ([EmpleadoId], [Nombre], [Apellido], [NumDoc], [CargoId], [Habilitado]) VALUES (2, N'Luis', N'Choquehuanca Arteta', N'45698365', N'M001', N'1')
INSERT [dbo].[Empleado] ([EmpleadoId], [Nombre], [Apellido], [NumDoc], [CargoId], [Habilitado]) VALUES (3, N'Lesly', N'Lopez Anchante', N'42569836', N'M001', N'1')
INSERT [dbo].[Empleado] ([EmpleadoId], [Nombre], [Apellido], [NumDoc], [CargoId], [Habilitado]) VALUES (4, N'Oscar', N'Ojeda Umiña', N'45778954', N'CO01', N'1')
SET IDENTITY_INSERT [dbo].[Empleado] OFF
INSERT [dbo].[EstadoDetallePedido] ([EstadoIDetalleId], [Descripcion], [Habilitado]) VALUES (1, N'Iniciado', N'1')
INSERT [dbo].[EstadoDetallePedido] ([EstadoIDetalleId], [Descripcion], [Habilitado]) VALUES (2, N'En proceso', N'1')
INSERT [dbo].[EstadoDetallePedido] ([EstadoIDetalleId], [Descripcion], [Habilitado]) VALUES (3, N'Terminado', N'1')
INSERT [dbo].[EstadoPedido] ([EstadoId], [Descripcion], [Habilitado]) VALUES (1, N'Emitido', N'1')
INSERT [dbo].[EstadoPedido] ([EstadoId], [Descripcion], [Habilitado]) VALUES (2, N'Procesado', N'1')
INSERT [dbo].[EstadoPedido] ([EstadoId], [Descripcion], [Habilitado]) VALUES (3, N'Anulado', N'1')
INSERT [dbo].[Mesa] ([MesaId], [NumMesa]) VALUES (1, 1)
INSERT [dbo].[Mesa] ([MesaId], [NumMesa]) VALUES (2, 2)
INSERT [dbo].[Mesa] ([MesaId], [NumMesa]) VALUES (3, 3)
INSERT [dbo].[Mesa] ([MesaId], [NumMesa]) VALUES (4, 4)
INSERT [dbo].[Mesa] ([MesaId], [NumMesa]) VALUES (5, 5)
INSERT [dbo].[MesaCamarero] ([MesaId], [EmpleadoId], [FechaInicio], [FechaFin]) VALUES (1, 3, CAST(0xAE8F0000 AS SmallDateTime), CAST(0xAE9D059F AS SmallDateTime))
INSERT [dbo].[MesaCamarero] ([MesaId], [EmpleadoId], [FechaInicio], [FechaFin]) VALUES (1, 2, CAST(0xAE6A0000 AS SmallDateTime), CAST(0xAE88059F AS SmallDateTime))
INSERT [dbo].[MesaCamarero] ([MesaId], [EmpleadoId], [FechaInicio], [FechaFin]) VALUES (2, 2, CAST(0xAE6A0000 AS SmallDateTime), CAST(0xAE88059F AS SmallDateTime))
INSERT [dbo].[MesaCamarero] ([MesaId], [EmpleadoId], [FechaInicio], [FechaFin]) VALUES (3, 4, CAST(0xAE6A0000 AS SmallDateTime), CAST(0xAE88059F AS SmallDateTime))
INSERT [dbo].[MesaCamarero] ([MesaId], [EmpleadoId], [FechaInicio], [FechaFin]) VALUES (4, 4, CAST(0xAE6A0000 AS SmallDateTime), CAST(0xAE88059F AS SmallDateTime))
INSERT [dbo].[MesaCamarero] ([MesaId], [EmpleadoId], [FechaInicio], [FechaFin]) VALUES (2, 2, CAST(0xAE880000 AS SmallDateTime), CAST(0xAEA6059F AS SmallDateTime))
INSERT [dbo].[MesaCamarero] ([MesaId], [EmpleadoId], [FechaInicio], [FechaFin]) VALUES (3, 4, CAST(0xAE880000 AS SmallDateTime), CAST(0xAEA6059F AS SmallDateTime))
INSERT [dbo].[MesaCamarero] ([MesaId], [EmpleadoId], [FechaInicio], [FechaFin]) VALUES (1, 3, CAST(0xAE7F0000 AS SmallDateTime), CAST(0xAE8E059F AS SmallDateTime))
SET IDENTITY_INSERT [dbo].[NotaPedido] ON 

INSERT [dbo].[NotaPedido] ([NumPedido], [FechaHoraSolicitud], [MontoPagar], [EmpleadoId], [NumMesa], [EstadoId], [Observacion], [ClienteId]) VALUES (1, CAST(0x0000AE80009F9F1B AS DateTime), CAST(103.00 AS Decimal(10, 2)), 2, 1, 2, NULL, 1)
INSERT [dbo].[NotaPedido] ([NumPedido], [FechaHoraSolicitud], [MontoPagar], [EmpleadoId], [NumMesa], [EstadoId], [Observacion], [ClienteId]) VALUES (2, CAST(0x0000AE8100F52E9D AS DateTime), CAST(55.00 AS Decimal(10, 2)), 2, 2, 2, N'', 1)
INSERT [dbo].[NotaPedido] ([NumPedido], [FechaHoraSolicitud], [MontoPagar], [EmpleadoId], [NumMesa], [EstadoId], [Observacion], [ClienteId]) VALUES (3, CAST(0x0000AE8100F9E5A2 AS DateTime), CAST(95.00 AS Decimal(10, 2)), 2, 1, 2, N'', 1)
INSERT [dbo].[NotaPedido] ([NumPedido], [FechaHoraSolicitud], [MontoPagar], [EmpleadoId], [NumMesa], [EstadoId], [Observacion], [ClienteId]) VALUES (4, CAST(0x0000AE8100FD4A91 AS DateTime), CAST(161.00 AS Decimal(10, 2)), 4, 3, 2, N'', 1)
INSERT [dbo].[NotaPedido] ([NumPedido], [FechaHoraSolicitud], [MontoPagar], [EmpleadoId], [NumMesa], [EstadoId], [Observacion], [ClienteId]) VALUES (5, CAST(0x0000AE81013E4E7A AS DateTime), CAST(230.00 AS Decimal(10, 2)), 4, 3, 2, N'', 1)
INSERT [dbo].[NotaPedido] ([NumPedido], [FechaHoraSolicitud], [MontoPagar], [EmpleadoId], [NumMesa], [EstadoId], [Observacion], [ClienteId]) VALUES (6, CAST(0x0000AE8201447FD4 AS DateTime), CAST(252.00 AS Decimal(10, 2)), 4, 4, 2, N'', 1)
INSERT [dbo].[NotaPedido] ([NumPedido], [FechaHoraSolicitud], [MontoPagar], [EmpleadoId], [NumMesa], [EstadoId], [Observacion], [ClienteId]) VALUES (7, CAST(0x0000AE82015810C1 AS DateTime), CAST(204.00 AS Decimal(10, 2)), 4, 3, 2, N'', 1)
INSERT [dbo].[NotaPedido] ([NumPedido], [FechaHoraSolicitud], [MontoPagar], [EmpleadoId], [NumMesa], [EstadoId], [Observacion], [ClienteId]) VALUES (8, CAST(0x0000AE84015EFB66 AS DateTime), CAST(76.00 AS Decimal(10, 2)), 4, 4, 2, N'', 1)
INSERT [dbo].[NotaPedido] ([NumPedido], [FechaHoraSolicitud], [MontoPagar], [EmpleadoId], [NumMesa], [EstadoId], [Observacion], [ClienteId]) VALUES (9, CAST(0x0000AE8501483DC7 AS DateTime), CAST(127.00 AS Decimal(10, 2)), 2, 1, 2, N'', 1)
INSERT [dbo].[NotaPedido] ([NumPedido], [FechaHoraSolicitud], [MontoPagar], [EmpleadoId], [NumMesa], [EstadoId], [Observacion], [ClienteId]) VALUES (10, CAST(0x0000AE85015E9D2C AS DateTime), CAST(143.00 AS Decimal(10, 2)), 4, 3, 2, N'', 1)
INSERT [dbo].[NotaPedido] ([NumPedido], [FechaHoraSolicitud], [MontoPagar], [EmpleadoId], [NumMesa], [EstadoId], [Observacion], [ClienteId]) VALUES (11, CAST(0x0000AE8501649E26 AS DateTime), CAST(21.00 AS Decimal(10, 2)), 2, 2, 2, N'', 1)
INSERT [dbo].[NotaPedido] ([NumPedido], [FechaHoraSolicitud], [MontoPagar], [EmpleadoId], [NumMesa], [EstadoId], [Observacion], [ClienteId]) VALUES (12, CAST(0x0000AE870107BF69 AS DateTime), CAST(360.00 AS Decimal(10, 2)), 3, 1, 2, N'', 1)
INSERT [dbo].[NotaPedido] ([NumPedido], [FechaHoraSolicitud], [MontoPagar], [EmpleadoId], [NumMesa], [EstadoId], [Observacion], [ClienteId]) VALUES (13, CAST(0x0000AE8701231463 AS DateTime), CAST(42.00 AS Decimal(10, 2)), 3, 1, 2, N'', 1)
INSERT [dbo].[NotaPedido] ([NumPedido], [FechaHoraSolicitud], [MontoPagar], [EmpleadoId], [NumMesa], [EstadoId], [Observacion], [ClienteId]) VALUES (14, CAST(0x0000AE88009D63D5 AS DateTime), CAST(405.00 AS Decimal(10, 2)), 3, 1, 1, N'', 1)
INSERT [dbo].[NotaPedido] ([NumPedido], [FechaHoraSolicitud], [MontoPagar], [EmpleadoId], [NumMesa], [EstadoId], [Observacion], [ClienteId]) VALUES (15, CAST(0x0000AE88009E2813 AS DateTime), CAST(148.00 AS Decimal(10, 2)), 3, 1, 1, N'', 1)
INSERT [dbo].[NotaPedido] ([NumPedido], [FechaHoraSolicitud], [MontoPagar], [EmpleadoId], [NumMesa], [EstadoId], [Observacion], [ClienteId]) VALUES (16, CAST(0x0000AE8800B1780B AS DateTime), CAST(149.00 AS Decimal(10, 2)), 2, 2, 1, N'', 1)
INSERT [dbo].[NotaPedido] ([NumPedido], [FechaHoraSolicitud], [MontoPagar], [EmpleadoId], [NumMesa], [EstadoId], [Observacion], [ClienteId]) VALUES (17, CAST(0x0000AE8B014EBD65 AS DateTime), CAST(90.00 AS Decimal(10, 2)), 4, 3, 1, N'', 1)
INSERT [dbo].[NotaPedido] ([NumPedido], [FechaHoraSolicitud], [MontoPagar], [EmpleadoId], [NumMesa], [EstadoId], [Observacion], [ClienteId]) VALUES (18, CAST(0x0000AE8E00E20660 AS DateTime), CAST(50.00 AS Decimal(10, 2)), 3, 1, 1, N'', 1)
SET IDENTITY_INSERT [dbo].[NotaPedido] OFF
INSERT [dbo].[TipoComprobante] ([TipoComID], [Descripcion], [Habilitado]) VALUES (1, N'Boleta', N'1')
INSERT [dbo].[TipoComprobante] ([TipoComID], [Descripcion], [Habilitado]) VALUES (2, N'Factura', N'1')
SET IDENTITY_INSERT [dbo].[Usuario] ON 

INSERT [dbo].[Usuario] ([UsuarioID], [Usuario], [Password], [Rol], [Habilitado], [EmpleadoId]) VALUES (1, N'kccalloc', N'123456', N'ADMIN', N'1', 1)
INSERT [dbo].[Usuario] ([UsuarioID], [Usuario], [Password], [Rol], [Habilitado], [EmpleadoId]) VALUES (2, N'lchoquehuanca', N'123456', N'VENTAS', N'1', 2)
INSERT [dbo].[Usuario] ([UsuarioID], [Usuario], [Password], [Rol], [Habilitado], [EmpleadoId]) VALUES (3, N'llopez', N'123456', N'VENTAS', N'1', 3)
INSERT [dbo].[Usuario] ([UsuarioID], [Usuario], [Password], [Rol], [Habilitado], [EmpleadoId]) VALUES (4, N'oojeda', N'123456', N'VENTAS', N'1', 4)
INSERT [dbo].[Usuario] ([UsuarioID], [Usuario], [Password], [Rol], [Habilitado], [EmpleadoId]) VALUES (5, N'cocina', N'cocina', N'COCINA', N'1', NULL)
SET IDENTITY_INSERT [dbo].[Usuario] OFF
ALTER TABLE [dbo].[Cargo] ADD  DEFAULT ('1') FOR [Habilitado]
GO
ALTER TABLE [dbo].[Carta] ADD  DEFAULT ('1') FOR [Habilitado]
GO
ALTER TABLE [dbo].[Categoria] ADD  DEFAULT ('1') FOR [Habilitado]
GO
ALTER TABLE [dbo].[Empleado] ADD  DEFAULT ('1') FOR [Habilitado]
GO
ALTER TABLE [dbo].[EstadoDetallePedido] ADD  DEFAULT ('1') FOR [Habilitado]
GO
ALTER TABLE [dbo].[EstadoPedido] ADD  DEFAULT ('1') FOR [Habilitado]
GO
ALTER TABLE [dbo].[TipoComprobante] ADD  DEFAULT ('1') FOR [Habilitado]
GO
ALTER TABLE [dbo].[Usuario] ADD  DEFAULT ('1') FOR [Habilitado]
GO
ALTER TABLE [dbo].[Carta]  WITH CHECK ADD  CONSTRAINT [FK_Carta.CategoriaId] FOREIGN KEY([CategoriaId])
REFERENCES [dbo].[Categoria] ([CategoriaId])
GO
ALTER TABLE [dbo].[Carta] CHECK CONSTRAINT [FK_Carta.CategoriaId]
GO
ALTER TABLE [dbo].[ComprobantePago]  WITH CHECK ADD  CONSTRAINT [FK_ComprobantePago.ClienteId] FOREIGN KEY([ClienteId])
REFERENCES [dbo].[Cliente] ([ClienteId])
GO
ALTER TABLE [dbo].[ComprobantePago] CHECK CONSTRAINT [FK_ComprobantePago.ClienteId]
GO
ALTER TABLE [dbo].[ComprobantePago]  WITH CHECK ADD  CONSTRAINT [FK_ComprobantePago.NumPedido] FOREIGN KEY([NumPedido])
REFERENCES [dbo].[NotaPedido] ([NumPedido])
GO
ALTER TABLE [dbo].[ComprobantePago] CHECK CONSTRAINT [FK_ComprobantePago.NumPedido]
GO
ALTER TABLE [dbo].[ComprobantePago]  WITH CHECK ADD  CONSTRAINT [FK_ComprobantePago.TipoComID] FOREIGN KEY([TipoComID])
REFERENCES [dbo].[TipoComprobante] ([TipoComID])
GO
ALTER TABLE [dbo].[ComprobantePago] CHECK CONSTRAINT [FK_ComprobantePago.TipoComID]
GO
ALTER TABLE [dbo].[DetallePedido]  WITH CHECK ADD  CONSTRAINT [FK_DetallePedido.CartaId] FOREIGN KEY([CartaId])
REFERENCES [dbo].[Carta] ([CartaId])
GO
ALTER TABLE [dbo].[DetallePedido] CHECK CONSTRAINT [FK_DetallePedido.CartaId]
GO
ALTER TABLE [dbo].[DetallePedido]  WITH CHECK ADD  CONSTRAINT [FK_DetallePedido.EstadoDetalleId] FOREIGN KEY([EstadoDetalleId])
REFERENCES [dbo].[EstadoDetallePedido] ([EstadoIDetalleId])
GO
ALTER TABLE [dbo].[DetallePedido] CHECK CONSTRAINT [FK_DetallePedido.EstadoDetalleId]
GO
ALTER TABLE [dbo].[DetallePedido]  WITH CHECK ADD  CONSTRAINT [FK_DetallePedido.NumPedido] FOREIGN KEY([NumPedido])
REFERENCES [dbo].[NotaPedido] ([NumPedido])
GO
ALTER TABLE [dbo].[DetallePedido] CHECK CONSTRAINT [FK_DetallePedido.NumPedido]
GO
ALTER TABLE [dbo].[Empleado]  WITH CHECK ADD  CONSTRAINT [FK_Empleado.CargoId] FOREIGN KEY([CargoId])
REFERENCES [dbo].[Cargo] ([CargoId])
GO
ALTER TABLE [dbo].[Empleado] CHECK CONSTRAINT [FK_Empleado.CargoId]
GO
ALTER TABLE [dbo].[MesaCamarero]  WITH CHECK ADD  CONSTRAINT [FK_MesaCamarero.EmpleadoId] FOREIGN KEY([EmpleadoId])
REFERENCES [dbo].[Empleado] ([EmpleadoId])
GO
ALTER TABLE [dbo].[MesaCamarero] CHECK CONSTRAINT [FK_MesaCamarero.EmpleadoId]
GO
ALTER TABLE [dbo].[MesaCamarero]  WITH CHECK ADD  CONSTRAINT [FK_MesaCamarero.MesaId] FOREIGN KEY([MesaId])
REFERENCES [dbo].[Mesa] ([MesaId])
GO
ALTER TABLE [dbo].[MesaCamarero] CHECK CONSTRAINT [FK_MesaCamarero.MesaId]
GO
ALTER TABLE [dbo].[NotaPedido]  WITH CHECK ADD  CONSTRAINT [FK_NotaPedido.EmpleadoId] FOREIGN KEY([EmpleadoId])
REFERENCES [dbo].[Empleado] ([EmpleadoId])
GO
ALTER TABLE [dbo].[NotaPedido] CHECK CONSTRAINT [FK_NotaPedido.EmpleadoId]
GO
ALTER TABLE [dbo].[NotaPedido]  WITH CHECK ADD  CONSTRAINT [FK_NotaPedido.EstadoId] FOREIGN KEY([EstadoId])
REFERENCES [dbo].[EstadoPedido] ([EstadoId])
GO
ALTER TABLE [dbo].[NotaPedido] CHECK CONSTRAINT [FK_NotaPedido.EstadoId]
GO
USE [master]
GO
ALTER DATABASE [BDRestaurante] SET  READ_WRITE 
GO
