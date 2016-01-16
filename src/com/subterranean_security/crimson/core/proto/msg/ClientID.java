// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: msg/ClientID.proto

package com.subterranean_security.crimson.core.proto.msg;

public final class ClientID {
  private ClientID() {}
  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistry registry) {
  }
  public interface AssignID_1WOrBuilder extends
      // @@protoc_insertion_point(interface_extends:com.subterranean_security.crimson.core.proto.msg.AssignID_1W)
      com.google.protobuf.MessageOrBuilder {

    /**
     * <code>required int32 id = 1;</code>
     */
    boolean hasId();
    /**
     * <code>required int32 id = 1;</code>
     */
    int getId();
  }
  /**
   * Protobuf type {@code com.subterranean_security.crimson.core.proto.msg.AssignID_1W}
   */
  public static final class AssignID_1W extends
      com.google.protobuf.GeneratedMessage implements
      // @@protoc_insertion_point(message_implements:com.subterranean_security.crimson.core.proto.msg.AssignID_1W)
      AssignID_1WOrBuilder {
    // Use AssignID_1W.newBuilder() to construct.
    private AssignID_1W(com.google.protobuf.GeneratedMessage.Builder<?> builder) {
      super(builder);
      this.unknownFields = builder.getUnknownFields();
    }
    private AssignID_1W(boolean noInit) { this.unknownFields = com.google.protobuf.UnknownFieldSet.getDefaultInstance(); }

    private static final AssignID_1W defaultInstance;
    public static AssignID_1W getDefaultInstance() {
      return defaultInstance;
    }

    public AssignID_1W getDefaultInstanceForType() {
      return defaultInstance;
    }

    private final com.google.protobuf.UnknownFieldSet unknownFields;
    @java.lang.Override
    public final com.google.protobuf.UnknownFieldSet
        getUnknownFields() {
      return this.unknownFields;
    }
    private AssignID_1W(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      initFields();
      int mutable_bitField0_ = 0;
      com.google.protobuf.UnknownFieldSet.Builder unknownFields =
          com.google.protobuf.UnknownFieldSet.newBuilder();
      try {
        boolean done = false;
        while (!done) {
          int tag = input.readTag();
          switch (tag) {
            case 0:
              done = true;
              break;
            default: {
              if (!parseUnknownField(input, unknownFields,
                                     extensionRegistry, tag)) {
                done = true;
              }
              break;
            }
            case 8: {
              bitField0_ |= 0x00000001;
              id_ = input.readInt32();
              break;
            }
          }
        }
      } catch (com.google.protobuf.InvalidProtocolBufferException e) {
        throw e.setUnfinishedMessage(this);
      } catch (java.io.IOException e) {
        throw new com.google.protobuf.InvalidProtocolBufferException(
            e.getMessage()).setUnfinishedMessage(this);
      } finally {
        this.unknownFields = unknownFields.build();
        makeExtensionsImmutable();
      }
    }
    public static final com.google.protobuf.Descriptors.Descriptor
        getDescriptor() {
      return com.subterranean_security.crimson.core.proto.msg.ClientID.internal_static_com_subterranean_security_crimson_core_proto_msg_AssignID_1W_descriptor;
    }

    protected com.google.protobuf.GeneratedMessage.FieldAccessorTable
        internalGetFieldAccessorTable() {
      return com.subterranean_security.crimson.core.proto.msg.ClientID.internal_static_com_subterranean_security_crimson_core_proto_msg_AssignID_1W_fieldAccessorTable
          .ensureFieldAccessorsInitialized(
              com.subterranean_security.crimson.core.proto.msg.ClientID.AssignID_1W.class, com.subterranean_security.crimson.core.proto.msg.ClientID.AssignID_1W.Builder.class);
    }

    public static com.google.protobuf.Parser<AssignID_1W> PARSER =
        new com.google.protobuf.AbstractParser<AssignID_1W>() {
      public AssignID_1W parsePartialFrom(
          com.google.protobuf.CodedInputStream input,
          com.google.protobuf.ExtensionRegistryLite extensionRegistry)
          throws com.google.protobuf.InvalidProtocolBufferException {
        return new AssignID_1W(input, extensionRegistry);
      }
    };

    @java.lang.Override
    public com.google.protobuf.Parser<AssignID_1W> getParserForType() {
      return PARSER;
    }

    private int bitField0_;
    public static final int ID_FIELD_NUMBER = 1;
    private int id_;
    /**
     * <code>required int32 id = 1;</code>
     */
    public boolean hasId() {
      return ((bitField0_ & 0x00000001) == 0x00000001);
    }
    /**
     * <code>required int32 id = 1;</code>
     */
    public int getId() {
      return id_;
    }

    private void initFields() {
      id_ = 0;
    }
    private byte memoizedIsInitialized = -1;
    public final boolean isInitialized() {
      byte isInitialized = memoizedIsInitialized;
      if (isInitialized == 1) return true;
      if (isInitialized == 0) return false;

      if (!hasId()) {
        memoizedIsInitialized = 0;
        return false;
      }
      memoizedIsInitialized = 1;
      return true;
    }

    public void writeTo(com.google.protobuf.CodedOutputStream output)
                        throws java.io.IOException {
      getSerializedSize();
      if (((bitField0_ & 0x00000001) == 0x00000001)) {
        output.writeInt32(1, id_);
      }
      getUnknownFields().writeTo(output);
    }

    private int memoizedSerializedSize = -1;
    public int getSerializedSize() {
      int size = memoizedSerializedSize;
      if (size != -1) return size;

      size = 0;
      if (((bitField0_ & 0x00000001) == 0x00000001)) {
        size += com.google.protobuf.CodedOutputStream
          .computeInt32Size(1, id_);
      }
      size += getUnknownFields().getSerializedSize();
      memoizedSerializedSize = size;
      return size;
    }

    private static final long serialVersionUID = 0L;
    @java.lang.Override
    protected java.lang.Object writeReplace()
        throws java.io.ObjectStreamException {
      return super.writeReplace();
    }

    public static com.subterranean_security.crimson.core.proto.msg.ClientID.AssignID_1W parseFrom(
        com.google.protobuf.ByteString data)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data);
    }
    public static com.subterranean_security.crimson.core.proto.msg.ClientID.AssignID_1W parseFrom(
        com.google.protobuf.ByteString data,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data, extensionRegistry);
    }
    public static com.subterranean_security.crimson.core.proto.msg.ClientID.AssignID_1W parseFrom(byte[] data)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data);
    }
    public static com.subterranean_security.crimson.core.proto.msg.ClientID.AssignID_1W parseFrom(
        byte[] data,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data, extensionRegistry);
    }
    public static com.subterranean_security.crimson.core.proto.msg.ClientID.AssignID_1W parseFrom(java.io.InputStream input)
        throws java.io.IOException {
      return PARSER.parseFrom(input);
    }
    public static com.subterranean_security.crimson.core.proto.msg.ClientID.AssignID_1W parseFrom(
        java.io.InputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      return PARSER.parseFrom(input, extensionRegistry);
    }
    public static com.subterranean_security.crimson.core.proto.msg.ClientID.AssignID_1W parseDelimitedFrom(java.io.InputStream input)
        throws java.io.IOException {
      return PARSER.parseDelimitedFrom(input);
    }
    public static com.subterranean_security.crimson.core.proto.msg.ClientID.AssignID_1W parseDelimitedFrom(
        java.io.InputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      return PARSER.parseDelimitedFrom(input, extensionRegistry);
    }
    public static com.subterranean_security.crimson.core.proto.msg.ClientID.AssignID_1W parseFrom(
        com.google.protobuf.CodedInputStream input)
        throws java.io.IOException {
      return PARSER.parseFrom(input);
    }
    public static com.subterranean_security.crimson.core.proto.msg.ClientID.AssignID_1W parseFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      return PARSER.parseFrom(input, extensionRegistry);
    }

    public static Builder newBuilder() { return Builder.create(); }
    public Builder newBuilderForType() { return newBuilder(); }
    public static Builder newBuilder(com.subterranean_security.crimson.core.proto.msg.ClientID.AssignID_1W prototype) {
      return newBuilder().mergeFrom(prototype);
    }
    public Builder toBuilder() { return newBuilder(this); }

    @java.lang.Override
    protected Builder newBuilderForType(
        com.google.protobuf.GeneratedMessage.BuilderParent parent) {
      Builder builder = new Builder(parent);
      return builder;
    }
    /**
     * Protobuf type {@code com.subterranean_security.crimson.core.proto.msg.AssignID_1W}
     */
    public static final class Builder extends
        com.google.protobuf.GeneratedMessage.Builder<Builder> implements
        // @@protoc_insertion_point(builder_implements:com.subterranean_security.crimson.core.proto.msg.AssignID_1W)
        com.subterranean_security.crimson.core.proto.msg.ClientID.AssignID_1WOrBuilder {
      public static final com.google.protobuf.Descriptors.Descriptor
          getDescriptor() {
        return com.subterranean_security.crimson.core.proto.msg.ClientID.internal_static_com_subterranean_security_crimson_core_proto_msg_AssignID_1W_descriptor;
      }

      protected com.google.protobuf.GeneratedMessage.FieldAccessorTable
          internalGetFieldAccessorTable() {
        return com.subterranean_security.crimson.core.proto.msg.ClientID.internal_static_com_subterranean_security_crimson_core_proto_msg_AssignID_1W_fieldAccessorTable
            .ensureFieldAccessorsInitialized(
                com.subterranean_security.crimson.core.proto.msg.ClientID.AssignID_1W.class, com.subterranean_security.crimson.core.proto.msg.ClientID.AssignID_1W.Builder.class);
      }

      // Construct using com.subterranean_security.crimson.core.proto.msg.ClientID.AssignID_1W.newBuilder()
      private Builder() {
        maybeForceBuilderInitialization();
      }

      private Builder(
          com.google.protobuf.GeneratedMessage.BuilderParent parent) {
        super(parent);
        maybeForceBuilderInitialization();
      }
      private void maybeForceBuilderInitialization() {
        if (com.google.protobuf.GeneratedMessage.alwaysUseFieldBuilders) {
        }
      }
      private static Builder create() {
        return new Builder();
      }

      public Builder clear() {
        super.clear();
        id_ = 0;
        bitField0_ = (bitField0_ & ~0x00000001);
        return this;
      }

      public Builder clone() {
        return create().mergeFrom(buildPartial());
      }

      public com.google.protobuf.Descriptors.Descriptor
          getDescriptorForType() {
        return com.subterranean_security.crimson.core.proto.msg.ClientID.internal_static_com_subterranean_security_crimson_core_proto_msg_AssignID_1W_descriptor;
      }

      public com.subterranean_security.crimson.core.proto.msg.ClientID.AssignID_1W getDefaultInstanceForType() {
        return com.subterranean_security.crimson.core.proto.msg.ClientID.AssignID_1W.getDefaultInstance();
      }

      public com.subterranean_security.crimson.core.proto.msg.ClientID.AssignID_1W build() {
        com.subterranean_security.crimson.core.proto.msg.ClientID.AssignID_1W result = buildPartial();
        if (!result.isInitialized()) {
          throw newUninitializedMessageException(result);
        }
        return result;
      }

      public com.subterranean_security.crimson.core.proto.msg.ClientID.AssignID_1W buildPartial() {
        com.subterranean_security.crimson.core.proto.msg.ClientID.AssignID_1W result = new com.subterranean_security.crimson.core.proto.msg.ClientID.AssignID_1W(this);
        int from_bitField0_ = bitField0_;
        int to_bitField0_ = 0;
        if (((from_bitField0_ & 0x00000001) == 0x00000001)) {
          to_bitField0_ |= 0x00000001;
        }
        result.id_ = id_;
        result.bitField0_ = to_bitField0_;
        onBuilt();
        return result;
      }

      public Builder mergeFrom(com.google.protobuf.Message other) {
        if (other instanceof com.subterranean_security.crimson.core.proto.msg.ClientID.AssignID_1W) {
          return mergeFrom((com.subterranean_security.crimson.core.proto.msg.ClientID.AssignID_1W)other);
        } else {
          super.mergeFrom(other);
          return this;
        }
      }

      public Builder mergeFrom(com.subterranean_security.crimson.core.proto.msg.ClientID.AssignID_1W other) {
        if (other == com.subterranean_security.crimson.core.proto.msg.ClientID.AssignID_1W.getDefaultInstance()) return this;
        if (other.hasId()) {
          setId(other.getId());
        }
        this.mergeUnknownFields(other.getUnknownFields());
        return this;
      }

      public final boolean isInitialized() {
        if (!hasId()) {
          
          return false;
        }
        return true;
      }

      public Builder mergeFrom(
          com.google.protobuf.CodedInputStream input,
          com.google.protobuf.ExtensionRegistryLite extensionRegistry)
          throws java.io.IOException {
        com.subterranean_security.crimson.core.proto.msg.ClientID.AssignID_1W parsedMessage = null;
        try {
          parsedMessage = PARSER.parsePartialFrom(input, extensionRegistry);
        } catch (com.google.protobuf.InvalidProtocolBufferException e) {
          parsedMessage = (com.subterranean_security.crimson.core.proto.msg.ClientID.AssignID_1W) e.getUnfinishedMessage();
          throw e;
        } finally {
          if (parsedMessage != null) {
            mergeFrom(parsedMessage);
          }
        }
        return this;
      }
      private int bitField0_;

      private int id_ ;
      /**
       * <code>required int32 id = 1;</code>
       */
      public boolean hasId() {
        return ((bitField0_ & 0x00000001) == 0x00000001);
      }
      /**
       * <code>required int32 id = 1;</code>
       */
      public int getId() {
        return id_;
      }
      /**
       * <code>required int32 id = 1;</code>
       */
      public Builder setId(int value) {
        bitField0_ |= 0x00000001;
        id_ = value;
        onChanged();
        return this;
      }
      /**
       * <code>required int32 id = 1;</code>
       */
      public Builder clearId() {
        bitField0_ = (bitField0_ & ~0x00000001);
        id_ = 0;
        onChanged();
        return this;
      }

      // @@protoc_insertion_point(builder_scope:com.subterranean_security.crimson.core.proto.msg.AssignID_1W)
    }

    static {
      defaultInstance = new AssignID_1W(true);
      defaultInstance.initFields();
    }

    // @@protoc_insertion_point(class_scope:com.subterranean_security.crimson.core.proto.msg.AssignID_1W)
  }

  private static final com.google.protobuf.Descriptors.Descriptor
    internal_static_com_subterranean_security_crimson_core_proto_msg_AssignID_1W_descriptor;
  private static
    com.google.protobuf.GeneratedMessage.FieldAccessorTable
      internal_static_com_subterranean_security_crimson_core_proto_msg_AssignID_1W_fieldAccessorTable;

  public static com.google.protobuf.Descriptors.FileDescriptor
      getDescriptor() {
    return descriptor;
  }
  private static com.google.protobuf.Descriptors.FileDescriptor
      descriptor;
  static {
    java.lang.String[] descriptorData = {
      "\n\022msg/ClientID.proto\0220com.subterranean_s" +
      "ecurity.crimson.core.proto.msg\"\031\n\013Assign" +
      "ID_1W\022\n\n\002id\030\001 \002(\005"
    };
    com.google.protobuf.Descriptors.FileDescriptor.InternalDescriptorAssigner assigner =
        new com.google.protobuf.Descriptors.FileDescriptor.    InternalDescriptorAssigner() {
          public com.google.protobuf.ExtensionRegistry assignDescriptors(
              com.google.protobuf.Descriptors.FileDescriptor root) {
            descriptor = root;
            return null;
          }
        };
    com.google.protobuf.Descriptors.FileDescriptor
      .internalBuildGeneratedFileFrom(descriptorData,
        new com.google.protobuf.Descriptors.FileDescriptor[] {
        }, assigner);
    internal_static_com_subterranean_security_crimson_core_proto_msg_AssignID_1W_descriptor =
      getDescriptor().getMessageTypes().get(0);
    internal_static_com_subterranean_security_crimson_core_proto_msg_AssignID_1W_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessage.FieldAccessorTable(
        internal_static_com_subterranean_security_crimson_core_proto_msg_AssignID_1W_descriptor,
        new java.lang.String[] { "Id", });
  }

  // @@protoc_insertion_point(outer_class_scope)
}
