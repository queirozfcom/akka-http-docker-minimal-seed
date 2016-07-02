package com.queirozf.models.responses

/**
  * Created by felipe on 02/07/16.
  */
case class SingleStockResult(dataset: Dataset)

case class Dataset(data: Data)

case class Data(values: List[Either[String, Double]])
