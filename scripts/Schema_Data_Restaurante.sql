USE [master]
GO
/****** Object:  Database [BDRestaurante]    Script Date: 23/4/2022 19:25:02 ******/
CREATE DATABASE [BDRestaurante]
GO
USE [BDRestaurante]
GO
/****** Object:  Table [dbo].[Cargo]    Script Date: 23/4/2022 19:25:02 ******/
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
/****** Object:  Table [dbo].[Carta]    Script Date: 23/4/2022 19:25:02 ******/
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
/****** Object:  Table [dbo].[Categoria]    Script Date: 23/4/2022 19:25:02 ******/
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
/****** Object:  Table [dbo].[Cliente]    Script Date: 23/4/2022 19:25:02 ******/
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
/****** Object:  Table [dbo].[ComprobantePago]    Script Date: 23/4/2022 19:25:02 ******/
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
/****** Object:  Table [dbo].[DetallePedido]    Script Date: 23/4/2022 19:25:02 ******/
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
/****** Object:  Table [dbo].[Empleado]    Script Date: 23/4/2022 19:25:02 ******/
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
/****** Object:  Table [dbo].[EstadoDetallePedido]    Script Date: 23/4/2022 19:25:02 ******/
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
/****** Object:  Table [dbo].[EstadoPedido]    Script Date: 23/4/2022 19:25:02 ******/
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
/****** Object:  Table [dbo].[Mesa]    Script Date: 23/4/2022 19:25:02 ******/
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
/****** Object:  Table [dbo].[MesaCamarero]    Script Date: 23/4/2022 19:25:02 ******/
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
/****** Object:  Table [dbo].[NotaPedido]    Script Date: 23/4/2022 19:25:02 ******/
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
/****** Object:  Table [dbo].[TipoComprobante]    Script Date: 23/4/2022 19:25:02 ******/
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
/****** Object:  Table [dbo].[Usuario]    Script Date: 23/4/2022 19:25:02 ******/
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
GO
INSERT [dbo].[Cargo] ([CargoId], [Descripcion], [Habilitado]) VALUES (N'AC01', N'Ayudante_cocina', N'1')
GO
INSERT [dbo].[Cargo] ([CargoId], [Descripcion], [Habilitado]) VALUES (N'CO01', N'Cocinero', N'1')
GO
INSERT [dbo].[Cargo] ([CargoId], [Descripcion], [Habilitado]) VALUES (N'G001', N'Gerente', N'1')
GO
INSERT [dbo].[Cargo] ([CargoId], [Descripcion], [Habilitado]) VALUES (N'L001', N'Limpieza', N'1')
GO
INSERT [dbo].[Cargo] ([CargoId], [Descripcion], [Habilitado]) VALUES (N'M001', N'Mozo', N'1')
GO
INSERT [dbo].[Carta] ([CartaId], [Nombre], [Descripcion], [Precio], [Descuento], [CategoriaId], [Habilitado], [Estado]) VALUES (1, N'Pollo a la brasa + cuarto', N'1 Pollo a la Brasa + 1/4 papas fritas + ensaladas + cremas', CAST(45.00 AS Decimal(10, 2)), CAST(0.00 AS Decimal(10, 2)), 1, N'1', N'DISPONIBLE')
GO
INSERT [dbo].[Carta] ([CartaId], [Nombre], [Descripcion], [Precio], [Descuento], [CategoriaId], [Habilitado], [Estado]) VALUES (2, N'Pollo a la Brasa', N'1 pollo a la brasa solo', CAST(25.00 AS Decimal(10, 2)), CAST(0.00 AS Decimal(10, 2)), 1, N'1', N'DISPONIBLE')
GO
INSERT [dbo].[Carta] ([CartaId], [Nombre], [Descripcion], [Precio], [Descuento], [CategoriaId], [Habilitado], [Estado]) VALUES (3, N'Arroz con pollo', N'Arroz con pollo', CAST(25.00 AS Decimal(10, 2)), CAST(0.00 AS Decimal(10, 2)), 2, N'1', N'DISPONIBLE')
GO
INSERT [dbo].[Carta] ([CartaId], [Nombre], [Descripcion], [Precio], [Descuento], [CategoriaId], [Habilitado], [Estado]) VALUES (4, N'Pollo a la brasa Personal', N'1/4 Pollo a la Brasa + 1/4 papas fritas + ensaladas + cremas', CAST(13.00 AS Decimal(10, 2)), CAST(0.00 AS Decimal(10, 2)), 2, N'1', N'DISPONIBLE')
GO
INSERT [dbo].[Carta] ([CartaId], [Nombre], [Descripcion], [Precio], [Descuento], [CategoriaId], [Habilitado], [Estado]) VALUES (5, N'Promo 1 Pollo + gaseosa', N'1 Pollo a la Brasa + 1/4 papas fritas + ensaladas + cremas+ 1 litro gaseosa', CAST(40.00 AS Decimal(10, 2)), CAST(15.00 AS Decimal(10, 2)), 7, N'1', N'DISPONIBLE')
GO
INSERT [dbo].[Carta] ([CartaId], [Nombre], [Descripcion], [Precio], [Descuento], [CategoriaId], [Habilitado], [Estado]) VALUES (6, N'Lomo Saltado de carne', N'Lomo Saltado de carne', CAST(10.00 AS Decimal(10, 2)), CAST(0.00 AS Decimal(10, 2)), 2, N'1', N'DISPONIBLE')
GO
INSERT [dbo].[Carta] ([CartaId], [Nombre], [Descripcion], [Precio], [Descuento], [CategoriaId], [Habilitado], [Estado]) VALUES (7, N'Pollo a la Plancha', N'Pollo a la Plancha', CAST(10.00 AS Decimal(10, 2)), CAST(0.00 AS Decimal(10, 2)), 2, N'1', N'DISPONIBLE')
GO
INSERT [dbo].[Carta] ([CartaId], [Nombre], [Descripcion], [Precio], [Descuento], [CategoriaId], [Habilitado], [Estado]) VALUES (8, N'Pollo a la Parrilla', N'Pollo a la Parrilla', CAST(15.00 AS Decimal(10, 2)), CAST(0.00 AS Decimal(10, 2)), 2, N'1', N'DISPONIBLE')
GO
INSERT [dbo].[Carta] ([CartaId], [Nombre], [Descripcion], [Precio], [Descuento], [CategoriaId], [Habilitado], [Estado]) VALUES (9, N'porcion de ensalada', N'Una porcion de ensalada', CAST(3.00 AS Decimal(10, 2)), CAST(0.00 AS Decimal(10, 2)), 3, N'1', N'DISPONIBLE')
GO
INSERT [dbo].[Carta] ([CartaId], [Nombre], [Descripcion], [Precio], [Descuento], [CategoriaId], [Habilitado], [Estado]) VALUES (10, N'porcion de ensalada mixta', N'Una porcion de ensalada mixta', CAST(3.50 AS Decimal(10, 2)), CAST(0.00 AS Decimal(10, 2)), 3, N'1', N'DISPONIBLE')
GO
INSERT [dbo].[Carta] ([CartaId], [Nombre], [Descripcion], [Precio], [Descuento], [CategoriaId], [Habilitado], [Estado]) VALUES (11, N'Porcion de helados de 3 sabores', N'Una Porcion de helados de 3 sabores', CAST(6.00 AS Decimal(10, 2)), CAST(0.00 AS Decimal(10, 2)), 4, N'1', N'DISPONIBLE')
GO
INSERT [dbo].[Carta] ([CartaId], [Nombre], [Descripcion], [Precio], [Descuento], [CategoriaId], [Habilitado], [Estado]) VALUES (12, N'Porcion de helados de 2 sabores', N'Una Porcion de helados de 2 sabores', CAST(4.00 AS Decimal(10, 2)), CAST(0.00 AS Decimal(10, 2)), 4, N'1', N'DISPONIBLE')
GO
INSERT [dbo].[Carta] ([CartaId], [Nombre], [Descripcion], [Precio], [Descuento], [CategoriaId], [Habilitado], [Estado]) VALUES (13, N'Porcion de torta selva negra', N'Una Porcion de torta selva negra', CAST(3.50 AS Decimal(10, 2)), CAST(0.00 AS Decimal(10, 2)), 4, N'1', N'DISPONIBLE')
GO
INSERT [dbo].[Carta] ([CartaId], [Nombre], [Descripcion], [Precio], [Descuento], [CategoriaId], [Habilitado], [Estado]) VALUES (14, N'Porcion de torta de chocolate', N'Una Porcion de torta de chocolate', CAST(3.50 AS Decimal(10, 2)), CAST(0.00 AS Decimal(10, 2)), 4, N'1', N'DISPONIBLE')
GO
INSERT [dbo].[Carta] ([CartaId], [Nombre], [Descripcion], [Precio], [Descuento], [CategoriaId], [Habilitado], [Estado]) VALUES (15, N'Porcion de torta de 3 leches', N'Una Porcion de torta de 3 leches', CAST(4.50 AS Decimal(10, 2)), CAST(0.00 AS Decimal(10, 2)), 4, N'1', N'DISPONIBLE')
GO
INSERT [dbo].[Carta] ([CartaId], [Nombre], [Descripcion], [Precio], [Descuento], [CategoriaId], [Habilitado], [Estado]) VALUES (16, N'litro de gaseosa inka kola', N'1 litro de gaseosa inka kola', CAST(5.00 AS Decimal(10, 2)), CAST(0.00 AS Decimal(10, 2)), 5, N'1', N'DISPONIBLE')
GO
INSERT [dbo].[Carta] ([CartaId], [Nombre], [Descripcion], [Precio], [Descuento], [CategoriaId], [Habilitado], [Estado]) VALUES (17, N'litro de gaseosa coca cola', N'1 litro de gaseosa coca cola', CAST(5.00 AS Decimal(10, 2)), CAST(0.00 AS Decimal(10, 2)), 5, N'1', N'DISPONIBLE')
GO
INSERT [dbo].[Carta] ([CartaId], [Nombre], [Descripcion], [Precio], [Descuento], [CategoriaId], [Habilitado], [Estado]) VALUES (18, N'gaseosa personal inka kola', N'1 gaseosa personal inka kola', CAST(2.00 AS Decimal(10, 2)), CAST(0.00 AS Decimal(10, 2)), 5, N'1', N'DISPONIBLE')
GO
INSERT [dbo].[Carta] ([CartaId], [Nombre], [Descripcion], [Precio], [Descuento], [CategoriaId], [Habilitado], [Estado]) VALUES (19, N'gaseosa personal coca cola', N'1 gaseosa personal coca cola', CAST(2.00 AS Decimal(10, 2)), CAST(0.00 AS Decimal(10, 2)), 5, N'1', N'DISPONIBLE')
GO
INSERT [dbo].[Carta] ([CartaId], [Nombre], [Descripcion], [Precio], [Descuento], [CategoriaId], [Habilitado], [Estado]) VALUES (20, N'botella de vino santiago queirolo', N'1 botella de vino santiago queirolo', CAST(25.00 AS Decimal(10, 2)), CAST(0.00 AS Decimal(10, 2)), 5, N'1', N'DISPONIBLE')
GO
INSERT [dbo].[Carta] ([CartaId], [Nombre], [Descripcion], [Precio], [Descuento], [CategoriaId], [Habilitado], [Estado]) VALUES (21, N'jarra de cerveza', N'1 jarra de cerveza', CAST(15.00 AS Decimal(10, 2)), CAST(0.00 AS Decimal(10, 2)), 5, N'1', N'DISPONIBLE')
GO
INSERT [dbo].[Carta] ([CartaId], [Nombre], [Descripcion], [Precio], [Descuento], [CategoriaId], [Habilitado], [Estado]) VALUES (22, N'agua mineral', N'1 agua mineral', CAST(1.50 AS Decimal(10, 2)), CAST(0.00 AS Decimal(10, 2)), 5, N'1', N'DISPONIBLE')
GO
INSERT [dbo].[Carta] ([CartaId], [Nombre], [Descripcion], [Precio], [Descuento], [CategoriaId], [Habilitado], [Estado]) VALUES (23, N'taza de cafe', N'taza de cafe', CAST(2.00 AS Decimal(10, 2)), CAST(0.00 AS Decimal(10, 2)), 6, N'1', N'DISPONIBLE')
GO
INSERT [dbo].[Carta] ([CartaId], [Nombre], [Descripcion], [Precio], [Descuento], [CategoriaId], [Habilitado], [Estado]) VALUES (24, N'taza de te', N'taza de te', CAST(2.00 AS Decimal(10, 2)), CAST(0.00 AS Decimal(10, 2)), 6, N'1', N'DISPONIBLE')
GO
INSERT [dbo].[Carta] ([CartaId], [Nombre], [Descripcion], [Precio], [Descuento], [CategoriaId], [Habilitado], [Estado]) VALUES (25, N'taza de manzanilla', N'taza de manzanilla', CAST(2.00 AS Decimal(10, 2)), CAST(0.00 AS Decimal(10, 2)), 6, N'1', N'DISPONIBLE')
GO
INSERT [dbo].[Carta] ([CartaId], [Nombre], [Descripcion], [Precio], [Descuento], [CategoriaId], [Habilitado], [Estado]) VALUES (26, N'pollo brosters', N'Porcion de pollo brosters', CAST(6.00 AS Decimal(10, 2)), CAST(0.00 AS Decimal(10, 2)), 8, N'1', N'DISPONIBLE')
GO
INSERT [dbo].[Carta] ([CartaId], [Nombre], [Descripcion], [Precio], [Descuento], [CategoriaId], [Habilitado], [Estado]) VALUES (28, N'Una Porcion de torta de chocolate fresa', N'Una Porcion de torta de chocolate fresa', CAST(12.00 AS Decimal(10, 2)), CAST(1.00 AS Decimal(10, 2)), 4, N'1', N'DISPONIBLE')
GO
INSERT [dbo].[Carta] ([CartaId], [Nombre], [Descripcion], [Precio], [Descuento], [CategoriaId], [Habilitado], [Estado]) VALUES (30, N'Una Porcion de torta de chocolate lucuma', N'Una Porcion de torta de chocolate lucuma', CAST(5.20 AS Decimal(10, 2)), CAST(0.00 AS Decimal(10, 2)), 4, N'1', N'DISPONIBLE')
GO
INSERT [dbo].[Categoria] ([CategoriaId], [Descripcion], [Habilitado]) VALUES (1, N'POLLOS A LA BRASA', N'1')
GO
INSERT [dbo].[Categoria] ([CategoriaId], [Descripcion], [Habilitado]) VALUES (2, N'PLATOS A LA CARTA', N'1')
GO
INSERT [dbo].[Categoria] ([CategoriaId], [Descripcion], [Habilitado]) VALUES (3, N'ENSALADAS', N'1')
GO
INSERT [dbo].[Categoria] ([CategoriaId], [Descripcion], [Habilitado]) VALUES (4, N'POSTRES', N'1')
GO
INSERT [dbo].[Categoria] ([CategoriaId], [Descripcion], [Habilitado]) VALUES (5, N'BEBIDAS', N'1')
GO
INSERT [dbo].[Categoria] ([CategoriaId], [Descripcion], [Habilitado]) VALUES (6, N'INFUSIONES', N'1')
GO
INSERT [dbo].[Categoria] ([CategoriaId], [Descripcion], [Habilitado]) VALUES (7, N'PROMOCION', N'1')
GO
INSERT [dbo].[Categoria] ([CategoriaId], [Descripcion], [Habilitado]) VALUES (8, N'BROSTERS', N'1')
GO
SET IDENTITY_INSERT [dbo].[Cliente] ON 

GO
INSERT [dbo].[Cliente] ([ClienteId], [ClienteName], [TipoDoc], [NumDoc], [Direccion], [Contacto]) VALUES (1, N'Sin Nombre ', N'DNI', N'Sin Documento', N'Sin Direccion', N'00000000')
GO
INSERT [dbo].[Cliente] ([ClienteId], [ClienteName], [TipoDoc], [NumDoc], [Direccion], [Contacto]) VALUES (2, N'Francisco Castro ', N'DNI', N'41254578', N'LIMA', N'985874589')
GO
SET IDENTITY_INSERT [dbo].[Cliente] OFF
GO
INSERT [dbo].[DetallePedido] ([NumPedido], [CartaId], [Cantidad], [Precio], [Importe], [EstadoDetalleId], [FechaHoraTermino]) VALUES (1, 1, 2, CAST(45.00 AS Decimal(10, 2)), CAST(90.00 AS Decimal(10, 2)), 2, CAST(0x0000AE80013E615C AS DateTime))
GO
INSERT [dbo].[DetallePedido] ([NumPedido], [CartaId], [Cantidad], [Precio], [Importe], [EstadoDetalleId], [FechaHoraTermino]) VALUES (1, 16, 2, CAST(5.00 AS Decimal(10, 2)), CAST(10.00 AS Decimal(10, 2)), 1, CAST(0x0000AE80009FA428 AS DateTime))
GO
INSERT [dbo].[DetallePedido] ([NumPedido], [CartaId], [Cantidad], [Precio], [Importe], [EstadoDetalleId], [FechaHoraTermino]) VALUES (1, 9, 1, CAST(3.00 AS Decimal(10, 2)), CAST(3.00 AS Decimal(10, 2)), 1, CAST(0x0000AE80009FA428 AS DateTime))
GO
SET IDENTITY_INSERT [dbo].[Empleado] ON 

GO
INSERT [dbo].[Empleado] ([EmpleadoId], [Nombre], [Apellido], [NumDoc], [CargoId], [Habilitado]) VALUES (1, N'Karla', N'Ccallo Choque', N'43078337', N'G001', N'1')
GO
INSERT [dbo].[Empleado] ([EmpleadoId], [Nombre], [Apellido], [NumDoc], [CargoId], [Habilitado]) VALUES (2, N'Luis', N'Choquehuanca Arteta', N'45698365', N'M001', N'1')
GO
INSERT [dbo].[Empleado] ([EmpleadoId], [Nombre], [Apellido], [NumDoc], [CargoId], [Habilitado]) VALUES (3, N'Lesly', N'Lopez Anchante', N'42569836', N'M001', N'1')
GO
INSERT [dbo].[Empleado] ([EmpleadoId], [Nombre], [Apellido], [NumDoc], [CargoId], [Habilitado]) VALUES (4, N'Oscar', N'Ojeda Umiña', N'45778954', N'CO01', N'1')
GO
SET IDENTITY_INSERT [dbo].[Empleado] OFF
GO
INSERT [dbo].[EstadoDetallePedido] ([EstadoIDetalleId], [Descripcion], [Habilitado]) VALUES (1, N'Iniciado', N'1')
GO
INSERT [dbo].[EstadoDetallePedido] ([EstadoIDetalleId], [Descripcion], [Habilitado]) VALUES (2, N'En proceso', N'1')
GO
INSERT [dbo].[EstadoDetallePedido] ([EstadoIDetalleId], [Descripcion], [Habilitado]) VALUES (3, N'Terminado', N'1')
GO
INSERT [dbo].[EstadoDetallePedido] ([EstadoIDetalleId], [Descripcion], [Habilitado]) VALUES (4, N'Entregado', N'1')
GO
INSERT [dbo].[EstadoPedido] ([EstadoId], [Descripcion], [Habilitado]) VALUES (1, N'Emitido', N'1')
GO
INSERT [dbo].[EstadoPedido] ([EstadoId], [Descripcion], [Habilitado]) VALUES (2, N'Procesado', N'1')
GO
INSERT [dbo].[EstadoPedido] ([EstadoId], [Descripcion], [Habilitado]) VALUES (3, N'Anulado', N'1')
GO
INSERT [dbo].[Mesa] ([MesaId], [NumMesa]) VALUES (1, 1)
GO
INSERT [dbo].[Mesa] ([MesaId], [NumMesa]) VALUES (2, 2)
GO
INSERT [dbo].[Mesa] ([MesaId], [NumMesa]) VALUES (3, 3)
GO
INSERT [dbo].[Mesa] ([MesaId], [NumMesa]) VALUES (4, 4)
GO
INSERT [dbo].[Mesa] ([MesaId], [NumMesa]) VALUES (5, 5)
GO
INSERT [dbo].[MesaCamarero] ([MesaId], [EmpleadoId], [FechaInicio], [FechaFin]) VALUES (1, 2, CAST(0xAE130000 AS SmallDateTime), CAST(0xAE140000 AS SmallDateTime))
GO
INSERT [dbo].[MesaCamarero] ([MesaId], [EmpleadoId], [FechaInicio], [FechaFin]) VALUES (2, 2, CAST(0xAE130000 AS SmallDateTime), CAST(0xAE140000 AS SmallDateTime))
GO
INSERT [dbo].[MesaCamarero] ([MesaId], [EmpleadoId], [FechaInicio], [FechaFin]) VALUES (3, 4, CAST(0xAE130000 AS SmallDateTime), CAST(0xAE140000 AS SmallDateTime))
GO
INSERT [dbo].[MesaCamarero] ([MesaId], [EmpleadoId], [FechaInicio], [FechaFin]) VALUES (4, 4, CAST(0xAE130000 AS SmallDateTime), CAST(0xAE140000 AS SmallDateTime))
GO
SET IDENTITY_INSERT [dbo].[NotaPedido] ON 

GO
INSERT [dbo].[NotaPedido] ([NumPedido], [FechaHoraSolicitud], [MontoPagar], [EmpleadoId], [NumMesa], [EstadoId], [Observacion], [ClienteId]) VALUES (1, CAST(0x0000AE80009F9F1B AS DateTime), CAST(103.00 AS Decimal(10, 2)), 2, 1, 1, NULL, 1)
GO
SET IDENTITY_INSERT [dbo].[NotaPedido] OFF
GO
INSERT [dbo].[TipoComprobante] ([TipoComID], [Descripcion], [Habilitado]) VALUES (1, N'Boleta', N'1')
GO
INSERT [dbo].[TipoComprobante] ([TipoComID], [Descripcion], [Habilitado]) VALUES (2, N'Factura', N'1')
GO
SET IDENTITY_INSERT [dbo].[Usuario] ON 

GO
INSERT [dbo].[Usuario] ([UsuarioID], [Usuario], [Password], [Rol], [Habilitado], [EmpleadoId]) VALUES (1, N'kccalloc', N'123456', N'ADMIN', N'1', 1)
GO
INSERT [dbo].[Usuario] ([UsuarioID], [Usuario], [Password], [Rol], [Habilitado], [EmpleadoId]) VALUES (2, N'lchoquehuanca', N'123456', N'VENTAS', N'1', 2)
GO
INSERT [dbo].[Usuario] ([UsuarioID], [Usuario], [Password], [Rol], [Habilitado], [EmpleadoId]) VALUES (3, N'llopez', N'123456', N'VENTAS', N'1', 3)
GO
INSERT [dbo].[Usuario] ([UsuarioID], [Usuario], [Password], [Rol], [Habilitado], [EmpleadoId]) VALUES (4, N'oojeda', N'123456', N'COCINA', N'1', 4)
GO
INSERT [dbo].[Usuario] ([UsuarioID], [Usuario], [Password], [Rol], [Habilitado], [EmpleadoId]) VALUES (5, N'cocina', N'cocina', N'COCINA', N'1', NULL)
GO
INSERT [dbo].[Usuario] ([UsuarioID], [Usuario], [Password], [Rol], [Habilitado], [EmpleadoId]) VALUES (8, N'prueba', N'prueba', N'VENTAS', N'1', 0)
GO
SET IDENTITY_INSERT [dbo].[Usuario] OFF
GO
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
