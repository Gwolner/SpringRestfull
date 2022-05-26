# Consumo da API Spring Restful

## :white_check_mark: Servico

### Inserir `POST` | `/Servico`

Enviar: 
```json
{
 "designacao":"Abrigo"
}
```

### Ler `GET` | `/Servico/{id}`

Retorno: 
```json
{
  "id": 1,
  "designacao": "Abrigo"
}
```

### Atualizar `PUT` | `/Servico`

Enviar: 
```json
{
 "id":"1",
 "designacao":"Abrigo"
}
```

### Ler Todos `GET` | `/Servicos`

Retorno:
```json
[
 {
  "id": 1,
  "designacao": "Abrigo"
 },
 {
  "id": 3,
  "designacao": "Abrigo"
 }
]
```

### Deletar `DELETE` | `/Servico/{id}`

## :white_check_mark: Acolhido

### Inserir `POST` | `/Acolhido`

Enviar: 
```json
{
  "cpf":"111.111.111-11",
  "rg":"8.147.598",
  "nome":"Bruce Wayne",
  "tipoContato":"Telegram",
  "contato":"(81)945875236",
  "dataNascimento":"12/05/1996",
  "coordenada":{
    "latitude":"66.40338",
    "longitude":"22.17403"
  }
}
```
**Observação:** Para casos de Acolhido sem coordenadas, a Latitude e a Longitude devem apresentar o valor 0.

### Ler `GET` | `Acolhido/{cpf}`

Retorno:
```json
{
	"cpf": "111.111.111-11",
	"rg": "8.147.598",
	"nome": "Bruce Wayne",
	"tipoContato": "Telegram",
	"contato": "(81)945875236",
	"dataNascimento": "12/05/1996",
	"coordenada": {
		"id": 11,
		"longitude": "22.17403",
		"latitude": "66.40338"
	}
}
```

### Atualizar `PUT` | `/Acolhido`

Enviar: 
```json
{
	"cpf": "111.111.111-11",
	"rg": "8.147.595",
	"nome": "Bruce Wayne",
	"tipoContato": "Telegram",
	"contato": "(81)945875236",
	"dataNascimento": "12/05/1996",
	"coordenada": {
		"id": 11,
		"longitude": "11.17403",
		"latitude": "66.40338"
	}
}
```
**Observação 1:** O CPF é enviado por ser uma PK. Não é permitido a alteração do CPF no banco de dados. <br/>
**Observação 2:** Para casos de Acolhido sem coordenadas, a Latitude e a Longitude devem apresentar o valor 0.

### Ler Todos `GET` | `/Acolhidos`

Retorno:
```json
[
	{
		"cpf": "111.111.111-11",
		"rg": "8.147.595",
		"nome": "Bruce Wayne",
		"tipoContato": "Telegram",
		"contato": "(87)945875236",
		"dataNascimento": "12/05/1996",
		"coordenada": {
			"id": 11,
			"longitude": "53.1262",
			"latitude": "17.1256"
		}
	},
	{
		"cpf": "333.111.111-11",
		"rg": "8.147.598",
		"nome": "Bruce Wayne",
		"tipoContato": "Telegram",
		"contato": "(81)945875236",
		"dataNascimento": "12/05/1996",
		"coordenada": {
			"id": 12,
			"longitude": "22.17403",
			"latitude": "66.40338"
		}
	},
	{
		"cpf": "555.111.111-11",
		"rg": "8.147.598",
		"nome": "Uélintoum Nunes",
		"tipoContato": "Telegram",
		"contato": "(81)945875236",
		"dataNascimento": "12/05/1996",
		"coordenada": {
			"id": 13,
			"longitude": "0",
			"latitude": "0"
		}
	}
]
```

### Deletar `DELETE` | `Acolhido/{cpf}`
