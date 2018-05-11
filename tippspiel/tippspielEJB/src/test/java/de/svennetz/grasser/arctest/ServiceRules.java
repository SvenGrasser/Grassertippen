package de.svennetz.grasser.arctest;

import static com.tngtech.archunit.lang.syntax.ArchRuleDefinition.classes;

import com.tngtech.archunit.junit.ArchTest;
import com.tngtech.archunit.lang.ArchRule;

public class ServiceRules {
	@ArchTest
	public static final ArchRule service_should_call_business = classes()
    .that().resideInAPackage("..services..")
    .should().accessClassesThat().resideInAPackage("..business..");
}
