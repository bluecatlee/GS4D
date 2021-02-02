package com.github.bluecatlee.gs4d.sequence.service;

import com.github.bluecatlee.gs4d.sequence.model.CreateSequence;

import java.util.List;
import java.util.Map;

public interface SequenceActionService {

    CreateSequence getSequenceToClient(CreateSequence var1);

    List<CreateSequence> getSequenceModelToClientCheck(CreateSequence var1);

    String getAutomicSeq(String seqName, Integer num, Long var3, Long var4);

    Integer getSeqStoreStatus(String seqName);

    @Deprecated
    List<Map<String, Object>> getOfflineSeqInfo(Long var1);
}
