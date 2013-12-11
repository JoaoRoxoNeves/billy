/**
 * Copyright (C) 2013 Premium Minds.
 *
 * This file is part of billy spain (ES Pack).
 *
 * billy spain (ES Pack) is free software: you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation, either version 3 of the License, or (at your option) any
 * later version.
 *
 * billy spain (ES Pack) is distributed in the hope that it will be useful, but WITHOUT ANY
 * WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS FOR
 * A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 *
 * You should have received a copy of the GNU Lesser General Public License
 * along with billy spain (ES Pack). If not, see <http://www.gnu.org/licenses/>.
 */
package com.premiumminds.billy.spain.services.export.pdf.receiptinvoice;

import java.io.InputStream;

import com.premiumminds.billy.gin.services.impl.pdf.AbstractTemplateBundle;
import com.premiumminds.billy.spain.services.export.pdf.ESTemplateBundle;
import com.premiumminds.billy.spain.util.PaymentMechanism;

public class ESReceiptInvoiceTemplateBundle extends AbstractTemplateBundle
		implements ESTemplateBundle {
	private static final String	BANK_TRANSFER_TEXT		= "Transferencia bancaria";
	private static final String	CASH_TEXT				= "Metálico";
	private static final String	CREDIT_CARD_TEXT		= "Tarjeta Crédito";
	private static final String	CHECK_TEXT				= "Cheque";
	private static final String	DEBIT_CARD_TEXT			= "Tarjeta Débito";
	private static final String	COMPENSATION_TEXT		= "Compensación de saldos en cuenta corriente";
	private static final String	COMMERCIAL_LETTER_TEXT	= "Letra comercial";
	private static final String	RESTAURANT_TICKET_TEXT	= "Ticket restaurante";
	private static final String	ATM_TEXT				= "Datáfono";
	private static final String	EXCHANGE_TEXT			= "Permuta";

	public ESReceiptInvoiceTemplateBundle(String logoImagePath,
			InputStream xsltFileStream) {
		super(logoImagePath, xsltFileStream);
	}

	@Override
	public String getPaymentMechanismTranslation(Enum<?> pmc) {
		if (null == pmc) {
			return null;
		}
		PaymentMechanism payment = (PaymentMechanism) pmc;
		switch (payment) {
			case BANK_TRANSFER:
				return ESReceiptInvoiceTemplateBundle.BANK_TRANSFER_TEXT;
			case CASH:
				return ESReceiptInvoiceTemplateBundle.CASH_TEXT;
			case CREDIT_CARD:
				return ESReceiptInvoiceTemplateBundle.CREDIT_CARD_TEXT;
			case CHECK:
				return ESReceiptInvoiceTemplateBundle.CHECK_TEXT;
			case DEBIT_CARD:
				return ESReceiptInvoiceTemplateBundle.DEBIT_CARD_TEXT;
			case COMPENSATION:
				return ESReceiptInvoiceTemplateBundle.COMPENSATION_TEXT;
			case COMMERCIAL_LETTER:
				return ESReceiptInvoiceTemplateBundle.COMMERCIAL_LETTER_TEXT;
			case ATM:
				return ESReceiptInvoiceTemplateBundle.ATM_TEXT;
			case RESTAURANT_TICKET:
				return ESReceiptInvoiceTemplateBundle.RESTAURANT_TICKET_TEXT;
			case EXCHANGE:
				return ESReceiptInvoiceTemplateBundle.EXCHANGE_TEXT;
			default:
				return null;
		}
	}
}
