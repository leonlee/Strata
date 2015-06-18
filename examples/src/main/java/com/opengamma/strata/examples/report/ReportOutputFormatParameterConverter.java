/**
 * Copyright (C) 2015 - present by OpenGamma Inc. and the OpenGamma group of companies
 * 
 * Please see distribution for license.
 */
package com.opengamma.strata.examples.report;

import com.beust.jcommander.IStringConverter;
import com.opengamma.strata.report.format.ReportOutputFormat;

/**
 * Parameter converter for {@link ReportOutputFormat}.
 */
public class ReportOutputFormatParameterConverter implements IStringConverter<ReportOutputFormat> {

  @Override
  public ReportOutputFormat convert(String value) {
    if (value.toLowerCase().startsWith("c")) {
      return ReportOutputFormat.CSV;
    }
    return ReportOutputFormat.ASCII_TABLE;
  }

}