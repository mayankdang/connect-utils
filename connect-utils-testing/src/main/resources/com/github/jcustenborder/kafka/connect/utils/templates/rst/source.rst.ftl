<#-- @formatter:off --><#include "common.rst.ftl">
<@section text=input.title/>

.. image:: ${input.diagramFileName}


<#if input.description??>
${input.description}
</#if>

<@notes input=input/>

<@configExamples input=input />